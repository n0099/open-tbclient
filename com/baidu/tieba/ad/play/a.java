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
    private String amf;
    private MediaPlayer bAy;
    private InterfaceC0279a cZb;
    private MediaPlayer.OnPreparedListener cZc;
    private MediaPlayer.OnErrorListener cZd;
    private MediaPlayer.OnCompletionListener cZe;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener cZf = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.cZc.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener cZg = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.cZe != null) {
                a.this.cZe.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener cZh = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.cZd != null) {
                a.this.cZd.onError(mediaPlayer, i, i2);
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
                a.this.aDJ();
            }
        }
    };
    private Runnable cZi = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cZh != null) {
                if (a.this.bAy != null) {
                    a.this.bAy.stop();
                }
                a.this.cZh.onError(a.this.bAy, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0279a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.amf = str;
        try {
            this.bAy = new MediaPlayer();
            this.bAy.setOnPreparedListener(this.cZf);
            this.bAy.setOnCompletionListener(this.cZg);
            this.bAy.setOnErrorListener(this.cZh);
            this.bAy.setDataSource(this.amf);
            this.bAy.setSurface(this.mSurface);
            this.bAy.setAudioStreamType(3);
            this.bAy.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.cZh.onError(this.bAy, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.cZh.onError(this.bAy, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.cZh.onError(this.bAy, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bAy != null) {
            try {
                this.bAy.stop();
                this.bAy.reset();
                setVideoPath(this.amf);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bAy.start();
                this.mCurrentState = 3;
                aDJ();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bAy.isPlaying()) {
                    this.bAy.pause();
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
                return this.bAy.getDuration();
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
                return this.bAy.getCurrentPosition();
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
                this.bAy.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bAy == null) {
            return false;
        }
        try {
            return this.bAy.isPlaying();
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
            return this.bAy.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bAy != null) {
            try {
                this.bAy.stop();
                this.bAy.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.iK().removeCallbacks(this.cZi);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cZc = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cZd = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cZe = onCompletionListener;
    }

    public void a(InterfaceC0279a interfaceC0279a) {
        this.cZb = interfaceC0279a;
    }

    private boolean isInPlaybackState() {
        return (this.bAy == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDJ() {
        this.mHandler.removeMessages(200);
        if (this.bAy != null && this.cZb != null) {
            int currentPosition = this.bAy.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.cZb.onPlay();
                    e.iK().removeCallbacks(this.cZi);
                }
            } else if (this.mCurrentState == 3) {
                this.cZb.onLoading();
                e.iK().removeCallbacks(this.cZi);
                e.iK().postDelayed(this.cZi, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
