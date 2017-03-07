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
    private static boolean aQi = false;
    private IMediaPlayer aQf;
    private c aQg;
    private Context mContext;
    private boolean aQh = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void cg(boolean z) throws RemoteException {
        this.aQh = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aQf = JB();
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aQf);
            }
            this.aQf.setOnPreparedListener(this.mOnPreparedListener);
            this.aQf.setOnCompletionListener(this.mOnCompletionListener);
            this.aQf.setOnErrorListener(this.mOnErrorListener);
            this.aQf.setOnInfoListener(this.mOnInfoListener);
            this.aQf.setDataSource(this.mContext, uri);
            this.aQf.setSurface(surface);
            this.aQf.setAudioStreamType(3);
            this.aQf.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aQf != null) {
            this.aQf.reset();
            this.aQf.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aQf);
            }
            this.aQf = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aQf != null) {
            this.aQf.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aQf != null) {
            this.aQf.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aQf != null) {
            return (int) this.aQf.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aQf != null) {
            return (int) this.aQf.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aQf != null) {
            this.aQf.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aQf != null) {
            return this.aQf.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aQf != null) {
            return this.aQf.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aQf != null) {
            return this.aQf.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aQf != null) {
            this.aQf.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aQf != null) {
            this.aQf.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aQf != null) {
            return this.aQf.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aQg = cVar;
    }

    public IMediaPlayer JB() {
        if (JC()) {
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
            aQi = true;
            return new v();
        }
    }

    private boolean JC() {
        return this.aQh || aQi || "MX4".equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean Jw() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.aQf);
    }
}
