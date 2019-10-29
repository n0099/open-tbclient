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
    private String aFy;
    private MediaPlayer bTe;
    private InterfaceC0311a diA;
    private MediaPlayer.OnPreparedListener diB;
    private MediaPlayer.OnErrorListener diC;
    private MediaPlayer.OnCompletionListener diD;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener diE = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.diB.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener diF = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.diD != null) {
                a.this.diD.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener diG = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.diC != null) {
                a.this.diC.onError(mediaPlayer, i, i2);
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
                a.this.aDS();
            }
        }
    };
    private Runnable diH = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.diG != null) {
                if (a.this.bTe != null) {
                    a.this.bTe.stop();
                }
                a.this.diG.onError(a.this.bTe, 0, 0);
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
        this.aFy = str;
        try {
            this.bTe = new MediaPlayer();
            this.bTe.setOnPreparedListener(this.diE);
            this.bTe.setOnCompletionListener(this.diF);
            this.bTe.setOnErrorListener(this.diG);
            this.bTe.setDataSource(this.aFy);
            this.bTe.setSurface(this.mSurface);
            this.bTe.setAudioStreamType(3);
            this.bTe.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.diG.onError(this.bTe, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.diG.onError(this.bTe, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.diG.onError(this.bTe, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bTe != null) {
            try {
                this.bTe.stop();
                this.bTe.reset();
                setVideoPath(this.aFy);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bTe.start();
                this.mCurrentState = 3;
                aDS();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bTe.isPlaying()) {
                    this.bTe.pause();
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
                return this.bTe.getDuration();
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
                return this.bTe.getCurrentPosition();
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
                this.bTe.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bTe == null) {
            return false;
        }
        try {
            return this.bTe.isPlaying();
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
            return this.bTe.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bTe != null) {
            try {
                this.bTe.stop();
                this.bTe.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.fZ().removeCallbacks(this.diH);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.diB = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.diC = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.diD = onCompletionListener;
    }

    public void a(InterfaceC0311a interfaceC0311a) {
        this.diA = interfaceC0311a;
    }

    private boolean isInPlaybackState() {
        return (this.bTe == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDS() {
        this.mHandler.removeMessages(200);
        if (this.bTe != null && this.diA != null) {
            int currentPosition = this.bTe.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.diA.onPlay();
                    e.fZ().removeCallbacks(this.diH);
                }
            } else if (this.mCurrentState == 3) {
                this.diA.onLoading();
                e.fZ().removeCallbacks(this.diH);
                e.fZ().postDelayed(this.diH, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
