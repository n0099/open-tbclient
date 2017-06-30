package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.QuickPlayer.b;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class h extends b.a {
    private static boolean aSn = false;
    private IMediaPlayer aSk;
    private c aSl;
    private Context mContext;
    private boolean aSm = false;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new i(this);
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new j(this);
    private IMediaPlayer.OnErrorListener mOnErrorListener = new k(this);
    private IMediaPlayer.OnInfoListener mOnInfoListener = new l(this);

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void cj(boolean z) throws RemoteException {
        this.aSm = z;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(Uri uri, Surface surface, String str) throws RemoteException {
        try {
            this.aSk = JK();
            if (JL() && !this.aSm) {
                int i = 0;
                if (aSn) {
                    i = 1;
                } else if ("MX4".equals(Build.MODEL)) {
                    i = 2;
                }
                TiebaStatic.log(new au("c12200").r("obj_type", i).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
            if (this.mContext instanceof a) {
                ((a) this.mContext).addPlayer(this.aSk);
            }
            this.aSk.setOnPreparedListener(this.mOnPreparedListener);
            this.aSk.setOnCompletionListener(this.mOnCompletionListener);
            this.aSk.setOnErrorListener(this.mOnErrorListener);
            this.aSk.setOnInfoListener(this.mOnInfoListener);
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Host", str);
                this.aSk.setDataSource(this.mContext, uri, hashMap);
            } else {
                this.aSk.setDataSource(this.mContext, uri);
            }
            this.aSk.setSurface(surface);
            this.aSk.setAudioStreamType(3);
            this.aSk.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void release() throws RemoteException {
        if (this.aSk != null) {
            this.aSk.reset();
            this.aSk.release();
            if (this.mContext instanceof a) {
                ((a) this.mContext).removePlayer(this.aSk);
            }
            this.aSk = null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void start() throws RemoteException {
        if (this.aSk != null) {
            this.aSk.start();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void pause() throws RemoteException {
        if (this.aSk != null) {
            this.aSk.pause();
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getDuration() throws RemoteException {
        if (this.aSk != null) {
            return (int) this.aSk.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getCurrentPosition() throws RemoteException {
        if (this.aSk != null) {
            return (int) this.aSk.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void seekTo(int i) throws RemoteException {
        if (this.aSk != null) {
            this.aSk.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isPlaying() throws RemoteException {
        if (this.aSk != null) {
            return this.aSk.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoWidth() throws RemoteException {
        if (this.aSk != null) {
            return this.aSk.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public int getVideoHeight() throws RemoteException {
        if (this.aSk != null) {
            return this.aSk.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setVolume(float f, float f2) throws RemoteException {
        if (this.aSk != null) {
            this.aSk.setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void setLooping(boolean z) throws RemoteException {
        if (this.aSk != null) {
            this.aSk.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean isLooping() throws RemoteException {
        if (this.aSk != null) {
            return this.aSk.isLooping();
        }
        return false;
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public void a(c cVar) throws RemoteException {
        this.aSl = cVar;
    }

    public IMediaPlayer JK() {
        if (JL()) {
            return new x();
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
            aSn = true;
            return new x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JL() {
        return this.aSm || aSn || "MX4".equals(Build.MODEL);
    }

    @Override // com.baidu.tieba.QuickPlayer.b
    public boolean JF() throws RemoteException {
        if (this.mContext == null || !(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).isExistInRemote(this.aSk);
    }
}
