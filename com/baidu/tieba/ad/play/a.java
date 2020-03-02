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
/* loaded from: classes8.dex */
public class a implements MediaController.MediaPlayerControl {
    private InterfaceC0405a dZJ;
    private MediaPlayer.OnPreparedListener dZK;
    private MediaPlayer.OnErrorListener dZL;
    private MediaPlayer.OnCompletionListener dZM;
    private int mLastPosition;
    private MediaPlayer mMediaPlayer;
    private Surface mSurface;
    private String mVideoPath;
    private int mCurrentState = 0;
    private MediaPlayer.OnPreparedListener dZN = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.ad.play.a.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 2;
            a.this.start();
            a.this.dZK.onPrepared(mediaPlayer);
        }
    };
    private MediaPlayer.OnCompletionListener dZO = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.ad.play.a.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.mCurrentState = 5;
            if (a.this.dZM != null) {
                a.this.dZM.onCompletion(mediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener dZP = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.ad.play.a.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.mCurrentState = -1;
            if (a.this.dZL != null) {
                a.this.dZL.onError(mediaPlayer, i, i2);
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
                a.this.aYu();
            }
        }
    };
    private Runnable dZQ = new Runnable() { // from class: com.baidu.tieba.ad.play.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dZP != null) {
                if (a.this.mMediaPlayer != null) {
                    a.this.mMediaPlayer.stop();
                }
                a.this.dZP.onError(a.this.mMediaPlayer, 0, 0);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ad.play.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0405a {
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
            this.mMediaPlayer.setOnPreparedListener(this.dZN);
            this.mMediaPlayer.setOnCompletionListener(this.dZO);
            this.mMediaPlayer.setOnErrorListener(this.dZP);
            this.mMediaPlayer.setDataSource(this.mVideoPath);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.prepareAsync();
            this.mLastPosition = 0;
            this.mCurrentState = 1;
        } catch (IOException e) {
            this.mCurrentState = -1;
            this.dZP.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalArgumentException e2) {
            this.mCurrentState = -1;
            this.dZP.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalStateException e3) {
            this.mCurrentState = -1;
            this.dZP.onError(this.mMediaPlayer, 1, 0);
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
                aYu();
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
        e.gx().removeCallbacks(this.dZQ);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dZK = onPreparedListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dZL = onErrorListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dZM = onCompletionListener;
    }

    public void a(InterfaceC0405a interfaceC0405a) {
        this.dZJ = interfaceC0405a;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYu() {
        this.mHandler.removeMessages(200);
        if (this.mMediaPlayer != null && this.dZJ != null) {
            int currentPosition = this.mMediaPlayer.getCurrentPosition();
            if (currentPosition != this.mLastPosition) {
                this.mLastPosition = currentPosition;
                if (this.mCurrentState == 3) {
                    this.dZJ.onPlay();
                    e.gx().removeCallbacks(this.dZQ);
                }
            } else if (this.mCurrentState == 3) {
                this.dZJ.onLoading();
                e.gx().removeCallbacks(this.dZQ);
                e.gx().postDelayed(this.dZQ, 6000L);
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(200), 1000L);
        }
    }
}
