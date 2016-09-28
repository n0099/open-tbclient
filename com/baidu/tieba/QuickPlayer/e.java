package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.tieba.QuickPlayer.a;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class e extends a.AbstractBinderC0050a {
    private static boolean aLn = false;
    private IMediaPlayer aLj;
    private b aLk;
    private int aLl;
    private Context mContext;
    private boolean aLm = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new f(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new g(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new h(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new i(this);

    public e(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void fE(int i) throws RemoteException {
        this.aLl = i;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void bZ(boolean z) throws RemoteException {
        this.aLm = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aLj = Ji();
            this.aLj.setOnPreparedListener(this.mOnPreparedListener);
            this.aLj.setOnCompletionListener(this.mOnCompletionListener);
            this.aLj.setOnErrorListener(this.mOnErrorListener);
            this.aLj.setOnInfoListener(this.mOnInfoListener);
            this.aLj.setDataSource(this.mContext, uri);
            this.aLj.setSurface(surface);
            this.aLj.setAudioStreamType(3);
            this.aLj.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void release() throws RemoteException {
        if (this.aLj != null) {
            this.aLj.stop();
            this.aLj.release();
            this.aLj = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void start() throws RemoteException {
        if (this.aLj != null) {
            this.aLj.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void pause() throws RemoteException {
        if (this.aLj != null) {
            this.aLj.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public int getDuration() throws RemoteException {
        if (this.aLj != null) {
            return (int) this.aLj.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public int getCurrentPosition() throws RemoteException {
        if (this.aLj != null) {
            return (int) this.aLj.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void seekTo(int i) throws RemoteException {
        if (this.aLj != null) {
            this.aLj.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public boolean isPlaying() throws RemoteException {
        if (this.aLj != null) {
            return this.aLj.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public int getVideoWidth() throws RemoteException {
        if (this.aLj != null) {
            return this.aLj.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public int getVideoHeight() throws RemoteException {
        if (this.aLj != null) {
            return this.aLj.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aLj != null) {
            this.aLj.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void setLooping(boolean z) throws RemoteException {
        if (this.aLj != null) {
            this.aLj.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public boolean isLooping() throws RemoteException {
        if (this.aLj != null) {
            return this.aLj.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void a(b bVar) throws RemoteException {
        this.aLk = bVar;
    }

    public IMediaPlayer Ji() {
        if (Jj()) {
            return new p();
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
            aLn = true;
            return new p();
        }
    }

    private boolean Jj() {
        return this.aLm || aLn || "MX4".equals(Build.MODEL);
    }
}
