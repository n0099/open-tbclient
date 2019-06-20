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
    private String ald;
    private MediaPlayer bzd;
    private InterfaceC0268a cVS;
    private MediaPlayer.OnPreparedListener cVT;
    private MediaPlayer.OnErrorListener cVU;
    private MediaPlayer.OnCompletionListener cVV;
    private int mLastPosition;
    private Surface mSurface;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener cVW = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.cVT.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener cVX = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.cVV != null) {
                a.this.cVV.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener cVY = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.cVU != null) {
                a.this.cVU.onError(mediaPlayer, i, i2);
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
                a.this.aBO();
            }
        }
    };
    private Runnable cVZ = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cVY != null) {
                if (a.this.bzd != null) {
                    a.this.bzd.stop();
                }
                a.this.cVY.onError(a.this.bzd, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0268a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.ald = str;
        try {
            this.bzd = new MediaPlayer();
            this.bzd.setOnPreparedListener(this.cVW);
            this.bzd.setOnCompletionListener(this.cVX);
            this.bzd.setOnErrorListener(this.cVY);
            this.bzd.setDataSource(this.ald);
            this.bzd.setSurface(this.mSurface);
            this.bzd.setAudioStreamType(3);
            this.bzd.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.cVY.onError(this.bzd, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.cVY.onError(this.bzd, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.cVY.onError(this.bzd, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.bzd != null) {
            try {
                this.bzd.stop();
                this.bzd.reset();
                setVideoPath(this.ald);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            try {
                this.bzd.start();
                this.mCurrentState = 3;
                aBO();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.bzd.isPlaying()) {
                    this.bzd.pause();
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
                return this.bzd.getDuration();
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
                return this.bzd.getCurrentPosition();
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
                this.bzd.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.bzd == null) {
            return false;
        }
        try {
            return this.bzd.isPlaying();
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
            return this.bzd.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.bzd != null) {
            try {
                this.bzd.stop();
                this.bzd.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.iB().removeCallbacks(this.cVZ);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cVT = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cVU = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cVV = onCompletionListener;
    }

    public void a(InterfaceC0268a interfaceC0268a) {
        this.cVS = interfaceC0268a;
    }

    private boolean isInPlaybackState() {
        return (this.bzd == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        this.mHandler.removeMessages(200);
        if (this.bzd != null && this.cVS != null) {
            int currentPosition = this.bzd.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.cVS.onPlay();
                    e.iB().removeCallbacks(this.cVZ);
                }
            } else if (this.mCurrentState == 3) {
                this.cVS.onLoading();
                e.iB().removeCallbacks(this.cVZ);
                e.iB().postDelayed(this.cVZ, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
