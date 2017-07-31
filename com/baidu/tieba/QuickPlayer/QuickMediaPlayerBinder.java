package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayer;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class QuickMediaPlayerBinder extends IQuickMediaPlayer.Stub {
    private static final String MODEL_MX4 = "MX4";
    private static boolean mCreatePlayerFailed = false;
    private Context mContext;
    private IMediaPlayer mMediaPlayer;
    private IQuickMediaPlayerListener mQuickMediaPlayerListener;
    private boolean mForceUseSystemMediaPlayer = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.1
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            try {
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onPrepared();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.QuickPlayer.QuickMediaPlayerBinder.2
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
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
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            int i3;
            try {
                if (QuickMediaPlayerBinder.this.needUseSystemMediaPlayer()) {
                    i3 = -100;
                } else {
                    i3 = SapiErrorCode.NETWORK_FAILED;
                }
                if (QuickMediaPlayerBinder.this.mQuickMediaPlayerListener != null) {
                    QuickMediaPlayerBinder.this.mQuickMediaPlayerListener.onError(i, i3);
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

    public QuickMediaPlayerBinder(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void forceUseSystemMediaPlayer(boolean z) throws RemoteException {
        this.mForceUseSystemMediaPlayer = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void openVideo(Uri uri, Surface surface, String str) throws RemoteException {
        try {
            this.mMediaPlayer = createPlayer();
            if (needUseSystemMediaPlayer() && !this.mForceUseSystemMediaPlayer) {
                int i = 0;
                if (mCreatePlayerFailed) {
                    i = 1;
                } else if (MODEL_MX4.equals(Build.MODEL)) {
                    i = 2;
                }
                TiebaStatic.log(new aj("c12200").r("obj_type", i).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.mMediaPlayer);
            }
            this.mMediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mOnInfoListener);
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Host", str);
                this.mMediaPlayer.setDataSource(this.mContext, uri, hashMap);
            } else {
                this.mMediaPlayer.setDataSource(this.mContext, uri);
            }
            this.mMediaPlayer.setSurface(surface);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void release() throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.mMediaPlayer);
            }
            this.mMediaPlayer = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void start() throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public void pause() throws RemoteException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public int getDuration() throws RemoteException {
        if (this.mMediaPlayer != null) {
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
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isPlaying() throws RemoteException {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.isPlaying();
        }
        return false;
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
            return ijkMediaPlayer;
        } catch (Throwable th) {
            th.printStackTrace();
            mCreatePlayerFailed = true;
            return new g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needUseSystemMediaPlayer() {
        return this.mForceUseSystemMediaPlayer || mCreatePlayerFailed || MODEL_MX4.equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
    public boolean isExistInRemote() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.mMediaPlayer);
    }
}
