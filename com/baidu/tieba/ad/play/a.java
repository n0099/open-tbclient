package com.baidu.tieba.ad.play;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.widget.MediaController;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a implements MediaController.MediaPlayerControl {
    private MediaPlayer Wd;
    private InterfaceC0175a byk;
    private MediaPlayer.OnPreparedListener byl;
    private MediaPlayer.OnErrorListener bym;
    private MediaPlayer.OnCompletionListener byn;
    private int mLastPosition;
    private Surface mSurface;
    private String mVideoPath;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener byo = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.byl.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener byp = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.byn != null) {
                a.this.byn.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener byq = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.bym != null) {
                a.this.bym.onError(mediaPlayer, i, i2);
                return true;
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ad.play.a.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 200) {
                a.this.Vd();
            }
        }
    };
    private Runnable byr = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.byq != null) {
                if (a.this.Wd != null) {
                    a.this.Wd.stop();
                }
                a.this.byq.onError(a.this.Wd, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0175a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
        try {
            this.Wd = new MediaPlayer();
            this.Wd.setOnPreparedListener(this.byo);
            this.Wd.setOnCompletionListener(this.byp);
            this.Wd.setOnErrorListener(this.byq);
            this.Wd.setDataSource(this.mVideoPath);
            this.Wd.setSurface(this.mSurface);
            this.Wd.setAudioStreamType(3);
            this.Wd.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.byq.onError(this.Wd, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.byq.onError(this.Wd, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.byq.onError(this.Wd, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.Wd != null) {
            try {
                this.Wd.stop();
                this.Wd.reset();
                setVideoPath(this.mVideoPath);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.Wd.start();
                this.mCurrentState = 3;
                Vd();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.Wd.isPlaying()) {
                    this.Wd.pause();
                    this.mCurrentState = 4;
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (isInPlaybackState()) {
            try {
                return this.Wd.getDuration();
            } catch (Exception e) {
                BdLog.e(e);
                return 0;
            }
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            try {
                return this.Wd.getCurrentPosition();
            } catch (Exception e) {
                BdLog.e(e);
                return 0;
            }
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (isInPlaybackState()) {
            try {
                this.Wd.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.Wd == null) {
            return false;
        }
        try {
            return this.Wd.isPlaying();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        try {
            return this.Wd.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.Wd != null) {
            try {
                this.Wd.stop();
                this.Wd.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.jG().removeCallbacks(this.byr);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.byl = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bym = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.byn = onCompletionListener;
    }

    public void a(InterfaceC0175a interfaceC0175a) {
        this.byk = interfaceC0175a;
    }

    private boolean isInPlaybackState() {
        return (this.Wd == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        this.mHandler.removeMessages(200);
        if (this.Wd != null && this.byk != null) {
            int currentPosition = this.Wd.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.byk.onPlay();
                    e.jG().removeCallbacks(this.byr);
                }
            } else if (this.mCurrentState == 3) {
                this.byk.onLoading();
                e.jG().removeCallbacks(this.byr);
                e.jG().postDelayed(this.byr, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
