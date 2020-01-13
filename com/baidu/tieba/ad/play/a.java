package com.baidu.tieba.ad.play;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.widget.MediaController;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a implements MediaController.MediaPlayerControl {
    private InterfaceC0394a dVE;
    private MediaPlayer.OnPreparedListener dVF;
    private MediaPlayer.OnErrorListener dVG;
    private MediaPlayer.OnCompletionListener dVH;
    private int mLastPosition;
    private MediaPlayer mMediaPlayer;
    private Surface mSurface;
    private String mVideoPath;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener dVI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.dVF.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener dVJ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.dVH != null) {
                a.this.dVH.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener dVK = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.dVG != null) {
                a.this.dVG.onError(mediaPlayer, i, i2);
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
                a.this.aWd();
            }
        }
    };
    private Runnable dVL = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dVK != null) {
                if (a.this.mMediaPlayer != null) {
                    a.this.mMediaPlayer.stop();
                }
                a.this.dVK.onError(a.this.mMediaPlayer, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0394a {
        void onLoading();

        void onPlay();
    }

    public a(Surface surface) {
        this.mSurface = surface;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
        try {
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setOnPreparedListener(this.dVI);
            this.mMediaPlayer.setOnCompletionListener(this.dVJ);
            this.mMediaPlayer.setOnErrorListener(this.dVK);
            this.mMediaPlayer.setDataSource(this.mVideoPath);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.dVK.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.dVK.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.dVK.onError(this.mMediaPlayer, 1, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void reset() {
        if (this.mMediaPlayer != null) {
            try {
                this.mMediaPlayer.stop();
                this.mMediaPlayer.reset();
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
                this.mMediaPlayer.start();
                this.mCurrentState = 3;
                aWd();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState()) {
            try {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.pause();
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
                return this.mMediaPlayer.getDuration();
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
                return this.mMediaPlayer.getCurrentPosition();
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
                this.mMediaPlayer.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCurrentState = 3;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.mMediaPlayer == null) {
            return false;
        }
        try {
            return this.mMediaPlayer.isPlaying();
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
            return this.mMediaPlayer.getAudioSessionId();
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }

    public void onDestroy() {
        if (this.mMediaPlayer != null) {
            try {
                this.mMediaPlayer.stop();
                this.mMediaPlayer.release();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        this.mHandler.removeMessages(200);
        e.gx().removeCallbacks(this.dVL);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dVF = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dVG = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dVH = onCompletionListener;
    }

    public void a(InterfaceC0394a interfaceC0394a) {
        this.dVE = interfaceC0394a;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWd() {
        this.mHandler.removeMessages(200);
        if (this.mMediaPlayer != null && this.dVE != null) {
            int currentPosition = this.mMediaPlayer.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.dVE.onPlay();
                    e.gx().removeCallbacks(this.dVL);
                }
            } else if (this.mCurrentState == 3) {
                this.dVE.onLoading();
                e.gx().removeCallbacks(this.dVL);
                e.gx().postDelayed(this.dVL, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
