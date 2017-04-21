package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.tieba.QuickPlayer.b;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class h extends b.a {
    private static boolean aQA = false;
    private IMediaPlayer aQx;
    private c aQy;
    private Context mContext;
    private boolean aQz = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void ci(boolean z) throws RemoteException {
        this.aQz = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aQx = Kb();
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aQx);
            }
            this.aQx.setOnPreparedListener(this.mOnPreparedListener);
            this.aQx.setOnCompletionListener(this.mOnCompletionListener);
            this.aQx.setOnErrorListener(this.mOnErrorListener);
            this.aQx.setOnInfoListener(this.mOnInfoListener);
            this.aQx.setDataSource(this.mContext, uri);
            this.aQx.setSurface(surface);
            this.aQx.setAudioStreamType(3);
            this.aQx.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aQx != null) {
            this.aQx.reset();
            this.aQx.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aQx);
            }
            this.aQx = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aQx != null) {
            this.aQx.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aQx != null) {
            this.aQx.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aQx != null) {
            return (int) this.aQx.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aQx != null) {
            return (int) this.aQx.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aQx != null) {
            this.aQx.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aQx != null) {
            return this.aQx.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aQx != null) {
            return this.aQx.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aQx != null) {
            return this.aQx.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aQx != null) {
            this.aQx.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aQx != null) {
            this.aQx.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aQx != null) {
            return this.aQx.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aQy = cVar;
    }

    public IMediaPlayer Kb() {
        if (Kc()) {
            return new v();
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
            aQA = true;
            return new v();
        }
    }

    private boolean Kc() {
        return this.aQz || aQA || "MX4".equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean JW() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.aQx);
    }
}
