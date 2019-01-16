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
    private MediaPlayer Wm;
    private MediaPlayer.OnCompletionListener bCA;
    private InterfaceC0185a bCx;
    private MediaPlayer.OnPreparedListener bCy;
    private MediaPlayer.OnErrorListener bCz;
    private int mLastPosition;
    private Surface mSurface;
    private String mVideoPath;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener bCB = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.bCy.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener bCC = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.bCA != null) {
                a.this.bCA.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener bCD = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.bCz != null) {
                a.this.bCz.onError(mediaPlayer, i, i2);
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
                a.this.WI();
            }
        }
    };
    private Runnable bCE = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bCD != null) {
                if (a.this.Wm != null) {
                    a.this.Wm.stop();
                }
                a.this.bCD.onError(a.this.Wm, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0185a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
        try {
            this.Wm = new MediaPlayer();
            this.Wm.setOnPreparedListener(this.bCB);
            this.Wm.setOnCompletionListener(this.bCC);
            this.Wm.setOnErrorListener(this.bCD);
            this.Wm.setDataSource(this.mVideoPath);
            this.Wm.setSurface(this.mSurface);
            this.Wm.setAudioStreamType(3);
            this.Wm.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.bCD.onError(this.Wm, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.bCD.onError(this.Wm, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.bCD.onError(this.Wm, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.Wm != null) {
            try {
                this.Wm.stop();
                this.Wm.reset();
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
                this.Wm.start();
                this.mCurrentState = 3;
                WI();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.Wm.isPlaying()) {
                    this.Wm.pause();
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
                return this.Wm.getDuration();
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
                return this.Wm.getCurrentPosition();
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
                this.Wm.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.Wm == null) {
            return false;
        }
        try {
            return this.Wm.isPlaying();
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
            return this.Wm.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.Wm != null) {
            try {
                this.Wm.stop();
                this.Wm.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.jG().removeCallbacks(this.bCE);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bCy = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bCz = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bCA = onCompletionListener;
    }

    public void a(InterfaceC0185a interfaceC0185a) {
        this.bCx = interfaceC0185a;
    }

    private boolean isInPlaybackState() {
        return (this.Wm == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WI() {
        this.mHandler.removeMessages(200);
        if (this.Wm != null && this.bCx != null) {
            int currentPosition = this.Wm.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.bCx.onPlay();
                    e.jG().removeCallbacks(this.bCE);
                }
            } else if (this.mCurrentState == 3) {
                this.bCx.onLoading();
                e.jG().removeCallbacks(this.bCE);
                e.jG().postDelayed(this.bCE, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
