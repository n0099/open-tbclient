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
    private MediaPlayer Wb;
    private MediaPlayer.OnPreparedListener bxA;
    private MediaPlayer.OnErrorListener bxB;
    private MediaPlayer.OnCompletionListener bxC;
    private InterfaceC0151a bxz;
    private int mLastPosition;
    private Surface mSurface;
    private String mVideoPath;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener bxD = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.bxA.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener bxE = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.bxC != null) {
                a.this.bxC.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener bxF = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.bxB != null) {
                a.this.bxB.onError(mediaPlayer, i, i2);
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
                a.this.UU();
            }
        }
    };
    private Runnable bxG = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bxF != null) {
                if (a.this.Wb != null) {
                    a.this.Wb.stop();
                }
                a.this.bxF.onError(a.this.Wb, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0151a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
        try {
            this.Wb = new MediaPlayer();
            this.Wb.setOnPreparedListener(this.bxD);
            this.Wb.setOnCompletionListener(this.bxE);
            this.Wb.setOnErrorListener(this.bxF);
            this.Wb.setDataSource(this.mVideoPath);
            this.Wb.setSurface(this.mSurface);
            this.Wb.setAudioStreamType(3);
            this.Wb.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.bxF.onError(this.Wb, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.bxF.onError(this.Wb, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.bxF.onError(this.Wb, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.Wb != null) {
            try {
                this.Wb.stop();
                this.Wb.reset();
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
                this.Wb.start();
                this.mCurrentState = 3;
                UU();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.Wb.isPlaying()) {
                    this.Wb.pause();
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
                return this.Wb.getDuration();
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
                return this.Wb.getCurrentPosition();
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
                this.Wb.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.Wb == null) {
            return false;
        }
        try {
            return this.Wb.isPlaying();
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
            return this.Wb.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.Wb != null) {
            try {
                this.Wb.stop();
                this.Wb.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.jI().removeCallbacks(this.bxG);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bxA = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bxB = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bxC = onCompletionListener;
    }

    public void a(InterfaceC0151a interfaceC0151a) {
        this.bxz = interfaceC0151a;
    }

    private boolean isInPlaybackState() {
        return (this.Wb == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UU() {
        this.mHandler.removeMessages(200);
        if (this.Wb != null && this.bxz != null) {
            int currentPosition = this.Wb.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.bxz.onPlay();
                    e.jI().removeCallbacks(this.bxG);
                }
            } else if (this.mCurrentState == 3) {
                this.bxz.onLoading();
                e.jI().removeCallbacks(this.bxG);
                e.jI().postDelayed(this.bxG, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
