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
    private static boolean aQy = false;
    private IMediaPlayer aQv;
    private c aQw;
    private Context mContext;
    private boolean aQx = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void ci(boolean z) throws RemoteException {
        this.aQx = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface) throws RemoteException {
        try {
            this.aQv = Kb();
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aQv);
            }
            this.aQv.setOnPreparedListener(this.mOnPreparedListener);
            this.aQv.setOnCompletionListener(this.mOnCompletionListener);
            this.aQv.setOnErrorListener(this.mOnErrorListener);
            this.aQv.setOnInfoListener(this.mOnInfoListener);
            this.aQv.setDataSource(this.mContext, uri);
            this.aQv.setSurface(surface);
            this.aQv.setAudioStreamType(3);
            this.aQv.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aQv != null) {
            this.aQv.reset();
            this.aQv.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aQv);
            }
            this.aQv = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aQv != null) {
            this.aQv.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aQv != null) {
            this.aQv.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aQv != null) {
            return (int) this.aQv.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aQv != null) {
            return (int) this.aQv.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aQv != null) {
            this.aQv.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aQv != null) {
            return this.aQv.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aQv != null) {
            return this.aQv.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aQv != null) {
            return this.aQv.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aQv != null) {
            this.aQv.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aQv != null) {
            this.aQv.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aQv != null) {
            return this.aQv.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aQw = cVar;
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
            aQy = true;
            return new v();
        }
    }

    private boolean Kc() {
        return this.aQx || aQy || "MX4".equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean JW() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.aQv);
    }
}
