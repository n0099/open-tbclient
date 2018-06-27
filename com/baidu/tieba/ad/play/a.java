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
    private MediaPlayer aXQ;
    private String bmV;
    private InterfaceC0129a bmW;
    private MediaPlayer.OnPreparedListener bmX;
    private MediaPlayer.OnErrorListener bmY;
    private MediaPlayer.OnCompletionListener bmZ;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener bna = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.bmX.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener bnb = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.bmZ != null) {
                a.this.bmZ.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener bnc = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.bmY != null) {
                a.this.bmY.onError(mediaPlayer, i, i2);
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
                a.this.QY();
            }
        }
    };
    private Runnable bnd = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bnc != null) {
                if (a.this.aXQ != null) {
                    a.this.aXQ.stop();
                }
                a.this.bnc.onError(a.this.aXQ, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0129a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.bmV = str;
        try {
            this.aXQ = new MediaPlayer();
            this.aXQ.setOnPreparedListener(this.bna);
            this.aXQ.setOnCompletionListener(this.bnb);
            this.aXQ.setOnErrorListener(this.bnc);
            this.aXQ.setDataSource(this.bmV);
            this.aXQ.setSurface(this.mSurface);
            this.aXQ.setAudioStreamType(3);
            this.aXQ.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.bnc.onError(this.aXQ, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.bnc.onError(this.aXQ, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.bnc.onError(this.aXQ, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.aXQ != null) {
            try {
                this.aXQ.stop();
                this.aXQ.reset();
                setVideoPath(this.bmV);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.aXQ.start();
                this.mCurrentState = 3;
                QY();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.aXQ.isPlaying()) {
                    this.aXQ.pause();
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
                return this.aXQ.getDuration();
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
                return this.aXQ.getCurrentPosition();
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
                this.aXQ.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.aXQ == null) {
            return false;
        }
        try {
            return this.aXQ.isPlaying();
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
            return this.aXQ.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.aXQ != null) {
            try {
                this.aXQ.stop();
                this.aXQ.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.im().removeCallbacks(this.bnd);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bmX = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bmY = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bmZ = onCompletionListener;
    }

    public void a(InterfaceC0129a interfaceC0129a) {
        this.bmW = interfaceC0129a;
    }

    private boolean isInPlaybackState() {
        return (this.aXQ == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QY() {
        this.mHandler.removeMessages(200);
        if (this.aXQ != null && this.bmW != null) {
            int currentPosition = this.aXQ.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.bmW.onPlay();
                    e.im().removeCallbacks(this.bnd);
                }
            } else if (this.mCurrentState == 3) {
                this.bmW.onLoading();
                e.im().removeCallbacks(this.bnd);
                e.im().postDelayed(this.bnd, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
