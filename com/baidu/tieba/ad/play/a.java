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
    private String akL;
    private MediaPlayer bsl;
    private InterfaceC0219a cNF;
    private MediaPlayer.OnPreparedListener cNG;
    private MediaPlayer.OnErrorListener cNH;
    private MediaPlayer.OnCompletionListener cNI;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener cNJ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.cNG.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener cNK = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.cNI != null) {
                a.this.cNI.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener cNL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.cNH != null) {
                a.this.cNH.onError(mediaPlayer, i, i2);
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
                a.this.awI();
            }
        }
    };
    private Runnable cNM = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cNL != null) {
                if (a.this.bsl != null) {
                    a.this.bsl.stop();
                }
                a.this.cNL.onError(a.this.bsl, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0219a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.akL = str;
        try {
            this.bsl = new MediaPlayer();
            this.bsl.setOnPreparedListener(this.cNJ);
            this.bsl.setOnCompletionListener(this.cNK);
            this.bsl.setOnErrorListener(this.cNL);
            this.bsl.setDataSource(this.akL);
            this.bsl.setSurface(this.mSurface);
            this.bsl.setAudioStreamType(3);
            this.bsl.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.cNL.onError(this.bsl, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.cNL.onError(this.bsl, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.cNL.onError(this.bsl, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bsl != null) {
            try {
                this.bsl.stop();
                this.bsl.reset();
                setVideoPath(this.akL);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bsl.start();
                this.mCurrentState = 3;
                awI();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bsl.isPlaying()) {
                    this.bsl.pause();
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
                return this.bsl.getDuration();
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
                return this.bsl.getCurrentPosition();
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
                this.bsl.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bsl == null) {
            return false;
        }
        try {
            return this.bsl.isPlaying();
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
            return this.bsl.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bsl != null) {
            try {
                this.bsl.stop();
                this.bsl.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.jH().removeCallbacks(this.cNM);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cNG = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cNH = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cNI = onCompletionListener;
    }

    public void a(InterfaceC0219a interfaceC0219a) {
        this.cNF = interfaceC0219a;
    }

    private boolean isInPlaybackState() {
        return (this.bsl == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awI() {
        this.mHandler.removeMessages(200);
        if (this.bsl != null && this.cNF != null) {
            int currentPosition = this.bsl.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.cNF.onPlay();
                    e.jH().removeCallbacks(this.cNM);
                }
            } else if (this.mCurrentState == 3) {
                this.cNF.onLoading();
                e.jH().removeCallbacks(this.cNM);
                e.jH().postDelayed(this.cNM, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
