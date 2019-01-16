package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes5.dex */
public class QuickMediaPlayerBinder extends IQuickMediaPlayer.Stub {
    private static final String MODEL_MX4 = "MX4";
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static boolean mCreatePlayerFailed = false;
    private boolean isReuse;
    private Context mContext;
    private IMediaPlayer mMediaPlayer;
    private boolean mPlayerReuseEnable;
    private IQuickMediaPlayerListener mQuickMediaPlayerListener;
    private int mSeekWhenPrepared;
    private Uri mUri;
    private int mCurrentState = 0;
    private int mTargetState = 0;
    private boolean mForceUseSystemMediaPlayer = false;
    private Map<String, String> mDebugParamsMap = new HashMap();
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.1
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            try {
                QuickMediaPlayerBinder.this.mCurrentState = 2;
                int i = QuickMediaPlayerBinder.this.mSeekWhenPrepared;
                if (i != 0) {
                    QuickMediaPlayerBinder.this.seekTo(i);
                }
                if (QuickMediaPlayerBinder.this.mTargetState == 3) {
                    QuickMediaPlayerBinder.this.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            QuickMediaPlayerBinder.this.mSeekWhenPrepared = 0;
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onPrepared();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.2
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            QuickMediaPlayerBinder.this.mCurrentState = 5;
            QuickMediaPlayerBinder.this.mTargetState = 5;
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onCompletion();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnErrorListener mOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.3
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2, int i3) {
            QuickMediaPlayerBinder.this.mCurrentState = -1;
            QuickMediaPlayerBinder.this.mTargetState = -1;
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onError(i, i2, i3);
                    return true;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    };
    private IMediaPlayer.OnInfoListener mOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.4
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onInfo(i, i2);
                    return true;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    };
    private IMediaPlayer.OnSubErrorInfoListener mOnSubErrorInfoListener = new IMediaPlayer.OnSubErrorInfoListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.5
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSubErrorInfoListener
        public void onSubError(int i, int i2, String str) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onSubError(i, i2, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnHandleOppoErrorListener mOnHandleOppoErrorListener = new IMediaPlayer.OnHandleOppoErrorListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.6
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnHandleOppoErrorListener
        public void handleOppoError(String str) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onHandleOppoError(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.7
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onSeekComplete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnSpeedWhenInvokingErrorListener mOnSpeedWhenInvokingErrorListener = new IMediaPlayer.OnSpeedWhenInvokingErrorListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.8
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSpeedWhenInvokingErrorListener
        public void onSpeed(long j) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onSpeedWhenError(j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public QuickMediaPlayerBinder(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void forceUseSystemMediaPlayer(boolean z) throws RemoteException {
        this.mForceUseSystemMediaPlayer = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void openVideo(Uri uri, Surface surface, String str, boolean z) throws RemoteException {
        int i;
        try {
            this.mUri = uri;
            if (this.mPlayerReuseEnable && !needUseSystemMediaPlayer() && (this.mContext instanceof a)) {
                this.mMediaPlayer = ((a) this.mContext).getPlayer(this.mUri);
                this.isReuse = true;
                if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                    this.mCurrentState = 0;
                    this.mTargetState = 0;
                }
            }
            if (this.mMediaPlayer == null) {
                this.isReuse = false;
                this.mMediaPlayer = createPlayer();
                this.mCurrentState = 0;
                this.mTargetState = 0;
                if (needUseSystemMediaPlayer() && !this.mForceUseSystemMediaPlayer) {
                    if (mCreatePlayerFailed) {
                        i = 1;
                    } else {
                        i = MODEL_MX4.equals(Build.MODEL) ? 2 : 0;
                    }
                    TiebaStatic.log(new am("c12200").y("obj_type", i).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.mContext instanceof a) {
                    ((a) this.mContext).addPlayer(this.mMediaPlayer, this.mUri);
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Host", str);
                    this.mMediaPlayer.setDataSource(this.mContext, uri, hashMap);
                } else {
                    this.mMediaPlayer.setDataSource(this.mContext, uri);
                }
            }
            this.mMediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            this.mMediaPlayer.setOnSubErrorListener(this.mOnSubErrorInfoListener);
            this.mMediaPlayer.setOnHandleOppoErrorListener(this.mOnHandleOppoErrorListener);
            this.mMediaPlayer.setOnSpeedWhenInvokingErrorListener(this.mOnSpeedWhenInvokingErrorListener);
            this.mMediaPlayer.setSurface(surface);
            if (!this.isReuse) {
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                return;
            }
            this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            this.mCurrentState = -1;
            this.mTargetState = -1;
            if (this.mOnSubErrorInfoListener != null) {
                this.mOnSubErrorInfoListener.onSubError(-24399, -24399, com.baidu.tieba.j.a.o(e));
            }
            if (this.mOnErrorListener != null) {
                this.mOnErrorListener.onError(this.mMediaPlayer, isIjkPlayer() ? -200 : -100, -24399, -24399);
            }
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            this.mCurrentState = -1;
            this.mTargetState = -1;
            if (this.mOnSubErrorInfoListener != null) {
                this.mOnSubErrorInfoListener.onSubError(-34399, -34399, com.baidu.tieba.j.a.o(e2));
            }
            if (this.mOnErrorListener != null) {
                this.mOnErrorListener.onError(this.mMediaPlayer, isIjkPlayer() ? -200 : -100, -34399, -34399);
            }
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void release() throws RemoteException {
        if (this.mMediaPlayer != null) {
            if (!this.mPlayerReuseEnable) {
                try {
                    this.mMediaPlayer.reset();
                } catch (Throwable th) {
                }
                this.mMediaPlayer.release();
            }
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.mUri);
            }
            this.mMediaPlayer = null;
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void start() throws RemoteException {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void pause() throws RemoteException {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getDuration() throws RemoteException {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getCurrentPosition() throws RemoteException {
        if (this.mMediaPlayer != null) {
            return (int) this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void seekTo(int i) throws RemoteException {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = i;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isPlaying() throws RemoteException {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getVideoWidth() throws RemoteException {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getVideoHeight() throws RemoteException {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void setLooping(boolean z) throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isLooping() throws RemoteException {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void setListener(IQuickMediaPlayerListener iQuickMediaPlayerListener) throws RemoteException {
        this.mQuickMediaPlayerListener = iQuickMediaPlayerListener;
    }

    public IMediaPlayer createPlayer() {
        if (needUseSystemMediaPlayer()) {
            return new g();
        }
        try {
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            IjkMediaPlayer.native_setLogLevel(3);
            ijkMediaPlayer.setOption(4, "mediacodec", 0L);
            ijkMediaPlayer.setOption(4, "opensles", 0L);
            ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 0L);
            ijkMediaPlayer.setOption(4, "enable-accurate-seek", 1L);
            for (Map.Entry<String, String> entry : this.mDebugParamsMap.entrySet()) {
                ijkMediaPlayer.setOption(4, entry.getKey(), entry.getValue());
            }
            return ijkMediaPlayer;
        } catch (Throwable th) {
            th.printStackTrace();
            mCreatePlayerFailed = true;
            return new g();
        }
    }

    private boolean needUseSystemMediaPlayer() {
        return this.mForceUseSystemMediaPlayer || mCreatePlayerFailed || MODEL_MX4.equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isExistInRemote() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.mMediaPlayer);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public List<String> getMediaIDs() {
        if (this.mContext instanceof a) {
            return ((a) this.mContext).getMediaIDs();
        }
        return null;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public String getId() {
        return this.mMediaPlayer == null ? "" : this.mMediaPlayer.generateMediaID();
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isIjkPlayer() throws RemoteException {
        return this.mMediaPlayer != null && (this.mMediaPlayer instanceof IjkMediaPlayer);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void setDebugParams(String str, String str2) throws RemoteException {
        this.mDebugParamsMap.put(str, str2);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getCachedPostion() throws RemoteException {
        if (isInPlaybackState() && isIjkPlayer()) {
            long audioCachedDuration = ((IjkMediaPlayer) this.mMediaPlayer).getAudioCachedDuration();
            long videoCachedDuration = ((IjkMediaPlayer) this.mMediaPlayer).getVideoCachedDuration();
            if (audioCachedDuration >= 0 && videoCachedDuration >= 0) {
                if (audioCachedDuration <= videoCachedDuration) {
                    videoCachedDuration = audioCachedDuration;
                }
                return (int) videoCachedDuration;
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getBitRate() throws RemoteException {
        if (isInPlaybackState() && isIjkPlayer()) {
            long bitRate = ((IjkMediaPlayer) this.mMediaPlayer).getBitRate();
            if (bitRate > 2147483647L) {
                return -1;
            }
            return (int) bitRate;
        }
        return -1;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getCachedSize() throws RemoteException {
        if (isInPlaybackState() && isIjkPlayer()) {
            long audioCachedBytes = ((IjkMediaPlayer) this.mMediaPlayer).getAudioCachedBytes();
            long videoCachedBytes = ((IjkMediaPlayer) this.mMediaPlayer).getVideoCachedBytes();
            if (audioCachedBytes >= 0 && videoCachedBytes >= 0) {
                return (int) (videoCachedBytes + audioCachedBytes);
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isPlayerReuse() {
        return this.isReuse;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void setSurface(Surface surface) throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }
}
