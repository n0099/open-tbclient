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
    private static boolean aMe = false;
    private IMediaPlayer aMb;
    private c aMc;
    private Context mContext;
    private boolean aMd = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void ce(boolean z) throws RemoteException {
        this.aMd = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aMb = Jo();
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aMb);
            }
            this.aMb.setOnPreparedListener(this.mOnPreparedListener);
            this.aMb.setOnCompletionListener(this.mOnCompletionListener);
            this.aMb.setOnErrorListener(this.mOnErrorListener);
            this.aMb.setOnInfoListener(this.mOnInfoListener);
            this.aMb.setDataSource(this.mContext, uri);
            this.aMb.setSurface(surface);
            this.aMb.setAudioStreamType(3);
            this.aMb.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aMb != null) {
            this.aMb.reset();
            this.aMb.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aMb);
            }
            this.aMb = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aMb != null) {
            this.aMb.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aMb != null) {
            this.aMb.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aMb != null) {
            return (int) this.aMb.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aMb != null) {
            return (int) this.aMb.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aMb != null) {
            this.aMb.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aMb != null) {
            return this.aMb.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aMb != null) {
            return this.aMb.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aMb != null) {
            return this.aMb.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aMb != null) {
            this.aMb.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aMb != null) {
            this.aMb.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aMb != null) {
            return this.aMb.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aMc = cVar;
    }

    public IMediaPlayer Jo() {
        if (Jp()) {
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
            aMe = true;
            return new v();
        }
    }

    private boolean Jp() {
        return this.aMd || aMe || "MX4".equals(Build.MODEL);
    }
}
