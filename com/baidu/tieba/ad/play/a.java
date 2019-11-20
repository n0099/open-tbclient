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
    private String aFg;
    private MediaPlayer bSn;
    private InterfaceC0311a dhI;
    private MediaPlayer.OnPreparedListener dhJ;
    private MediaPlayer.OnErrorListener dhK;
    private MediaPlayer.OnCompletionListener dhL;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener dhM = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.dhJ.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener dhN = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.dhL != null) {
                a.this.dhL.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener dhO = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.dhK != null) {
                a.this.dhK.onError(mediaPlayer, i, i2);
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
                a.this.aDQ();
            }
        }
    };
    private Runnable dhP = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dhO != null) {
                if (a.this.bSn != null) {
                    a.this.bSn.stop();
                }
                a.this.dhO.onError(a.this.bSn, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0311a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.aFg = str;
        try {
            this.bSn = new MediaPlayer();
            this.bSn.setOnPreparedListener(this.dhM);
            this.bSn.setOnCompletionListener(this.dhN);
            this.bSn.setOnErrorListener(this.dhO);
            this.bSn.setDataSource(this.aFg);
            this.bSn.setSurface(this.mSurface);
            this.bSn.setAudioStreamType(3);
            this.bSn.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.dhO.onError(this.bSn, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.dhO.onError(this.bSn, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.dhO.onError(this.bSn, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bSn != null) {
            try {
                this.bSn.stop();
                this.bSn.reset();
                setVideoPath(this.aFg);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bSn.start();
                this.mCurrentState = 3;
                aDQ();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bSn.isPlaying()) {
                    this.bSn.pause();
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
                return this.bSn.getDuration();
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
                return this.bSn.getCurrentPosition();
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
                this.bSn.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bSn == null) {
            return false;
        }
        try {
            return this.bSn.isPlaying();
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
            return this.bSn.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bSn != null) {
            try {
                this.bSn.stop();
                this.bSn.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.fZ().removeCallbacks(this.dhP);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dhJ = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dhK = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dhL = onCompletionListener;
    }

    public void a(InterfaceC0311a interfaceC0311a) {
        this.dhI = interfaceC0311a;
    }

    private boolean isInPlaybackState() {
        return (this.bSn == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDQ() {
        this.mHandler.removeMessages(200);
        if (this.bSn != null && this.dhI != null) {
            int currentPosition = this.bSn.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.dhI.onPlay();
                    e.fZ().removeCallbacks(this.dhP);
                }
            } else if (this.mCurrentState == 3) {
                this.dhI.onLoading();
                e.fZ().removeCallbacks(this.dhP);
                e.fZ().postDelayed(this.dhP, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
