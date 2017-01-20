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
    private static boolean aKx = false;
    private IMediaPlayer aKu;
    private c aKv;
    private Context mContext;
    private boolean aKw = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void ch(boolean z) throws RemoteException {
        this.aKw = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aKu = IW();
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aKu);
            }
            this.aKu.setOnPreparedListener(this.mOnPreparedListener);
            this.aKu.setOnCompletionListener(this.mOnCompletionListener);
            this.aKu.setOnErrorListener(this.mOnErrorListener);
            this.aKu.setOnInfoListener(this.mOnInfoListener);
            this.aKu.setDataSource(this.mContext, uri);
            this.aKu.setSurface(surface);
            this.aKu.setAudioStreamType(3);
            this.aKu.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aKu != null) {
            this.aKu.reset();
            this.aKu.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aKu);
            }
            this.aKu = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aKu != null) {
            this.aKu.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aKu != null) {
            this.aKu.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aKu != null) {
            return (int) this.aKu.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aKu != null) {
            return (int) this.aKu.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aKu != null) {
            this.aKu.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aKu != null) {
            return this.aKu.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aKu != null) {
            return this.aKu.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aKu != null) {
            return this.aKu.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aKu != null) {
            this.aKu.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aKu != null) {
            this.aKu.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aKu != null) {
            return this.aKu.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aKv = cVar;
    }

    public IMediaPlayer IW() {
        if (IX()) {
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
            aKx = true;
            return new v();
        }
    }

    private boolean IX() {
        return this.aKw || aKx || "MX4".equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean IR() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.aKu);
    }
}
