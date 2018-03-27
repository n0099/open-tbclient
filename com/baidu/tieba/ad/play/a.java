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
    private MediaPlayer bTh;
    private String bTi;
    private InterfaceC0124a bTj;
    private MediaPlayer.OnPreparedListener bTk;
    private MediaPlayer.OnErrorListener bTl;
    private MediaPlayer.OnCompletionListener bTm;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener bTn = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.bTk.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener bTo = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.bTm != null) {
                a.this.bTm.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener bTp = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.bTl != null) {
                a.this.bTl.onError(mediaPlayer, i, i2);
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
                a.this.UC();
            }
        }
    };
    private Runnable bTq = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTp != null) {
                if (a.this.bTh != null) {
                    a.this.bTh.stop();
                }
                a.this.bTp.onError(a.this.bTh, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0124a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.bTi = str;
        try {
            this.bTh = new MediaPlayer();
            this.bTh.setOnPreparedListener(this.bTn);
            this.bTh.setOnCompletionListener(this.bTo);
            this.bTh.setOnErrorListener(this.bTp);
            this.bTh.setDataSource(this.bTi);
            this.bTh.setSurface(this.mSurface);
            this.bTh.setAudioStreamType(3);
            this.bTh.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.bTp.onError(this.bTh, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.bTp.onError(this.bTh, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.bTp.onError(this.bTh, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bTh != null) {
            try {
                this.bTh.stop();
                this.bTh.reset();
                setVideoPath(this.bTi);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bTh.start();
                this.mCurrentState = 3;
                UC();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bTh.isPlaying()) {
                    this.bTh.pause();
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
                return this.bTh.getDuration();
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
                return this.bTh.getCurrentPosition();
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
                this.bTh.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bTh == null) {
            return false;
        }
        try {
            return this.bTh.isPlaying();
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
            return this.bTh.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bTh != null) {
            try {
                this.bTh.stop();
                this.bTh.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.ns().removeCallbacks(this.bTq);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bTk = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bTl = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bTm = onCompletionListener;
    }

    public void a(InterfaceC0124a interfaceC0124a) {
        this.bTj = interfaceC0124a;
    }

    private boolean isInPlaybackState() {
        return (this.bTh == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UC() {
        this.mHandler.removeMessages(200);
        if (this.bTh != null && this.bTj != null) {
            int currentPosition = this.bTh.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.bTj.onPlay();
                    e.ns().removeCallbacks(this.bTq);
                }
            } else if (this.mCurrentState == 3) {
                this.bTj.onLoading();
                e.ns().removeCallbacks(this.bTq);
                e.ns().postDelayed(this.bTq, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
