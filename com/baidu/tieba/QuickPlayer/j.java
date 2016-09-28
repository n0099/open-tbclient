package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.SparseArray;
import com.baidu.tieba.QuickPlayer.b;
import com.baidu.tieba.play.e;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.play.e {
    private static final String TAG = j.class.getSimpleName();
    private static a aLw = new a();
    private static SparseArray<j> aLy = new SparseArray<>();
    private int aLl;
    private com.baidu.tieba.QuickPlayer.a aLp;
    private e.a aLq;
    private e.d aLr;
    private e.b aLs;
    private e.c aLt;
    private c aLv;
    private Context mContext;
    private boolean aLx = false;
    private Handler.Callback aLz = new k(this);
    private ServiceConnection aLA = new l(this);
    private Handler.Callback aLB = new m(this);
    private Handler mHandler = new Handler(d.Jh().getLooper(), this.aLz);
    private Handler aLu = new Handler(Looper.getMainLooper(), this.aLB);

    @Override // com.baidu.tieba.play.e
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture) {
        this.aLl = hashCode();
        aLy.put(this.aLl, this);
        this.mContext = context;
        c cVar = new c();
        cVar.setUri(uri);
        cVar.setHeaders(map);
        cVar.a(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = cVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        this.aLv = cVar;
        if (this.mContext != null) {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.aLA, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends b.a {
        a() {
        }

        @Override // com.baidu.tieba.QuickPlayer.b
        public void fF(int i) throws RemoteException {
            N(i, 6);
        }

        @Override // com.baidu.tieba.QuickPlayer.b
        public void fG(int i) throws RemoteException {
            N(i, 7);
        }

        @Override // com.baidu.tieba.QuickPlayer.b
        public void q(int i, int i2, int i3) throws RemoteException {
            i(i, 8, i2, i3);
        }

        @Override // com.baidu.tieba.QuickPlayer.b
        public void r(int i, int i2, int i3) throws RemoteException {
            i(i, 9, i2, i3);
        }

        private void N(int i, int i2) {
            i(i, i2, 0, 0);
        }

        private void i(int i, int i2, int i3, int i4) {
            if (j.aLy.get(i) != null && ((j) j.aLy.get(i)).aLu != null) {
                Handler handler = ((j) j.aLy.get(i)).aLu;
                Message obtainMessage = handler.obtainMessage(i2);
                obtainMessage.arg1 = i3;
                obtainMessage.arg2 = i4;
                handler.sendMessage(obtainMessage);
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public void release() {
        aLy.remove(this.aLl);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.QuickPlayer.a aVar) {
        if (aVar != null) {
            try {
                aVar.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.aLx) {
            try {
                this.mContext.unbindService(this.aLA);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.aLx = false;
        }
    }

    @Override // com.baidu.tieba.play.e
    public void setOnPreparedListener(e.d dVar) {
        this.aLr = dVar;
    }

    @Override // com.baidu.tieba.play.e
    public void setOnCompletionListener(e.a aVar) {
        this.aLq = aVar;
    }

    @Override // com.baidu.tieba.play.e
    public void setOnErrorListener(e.b bVar) {
        this.aLs = bVar;
    }

    @Override // com.baidu.tieba.play.e
    public void a(e.c cVar) {
        this.aLt = cVar;
    }

    @Override // com.baidu.tieba.play.e
    public void start() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.QuickPlayer.a aVar) {
        if (aVar != null) {
            try {
                aVar.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public void pause() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.QuickPlayer.a aVar) {
        if (aVar != null) {
            try {
                aVar.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public int getDuration() {
        if (this.aLp != null) {
            try {
                return this.aLp.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.aLp != null) {
            try {
                return this.aLp.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.e
    public int getVideoWidth() {
        if (this.aLp != null) {
            try {
                return this.aLp.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.e
    public int getVideoHeight() {
        if (this.aLp != null) {
            try {
                return this.aLp.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.e
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(int i) {
        if (this.aLp != null) {
            try {
                this.aLp.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.aLp != null) {
            try {
                return this.aLp.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void setVolume(float f, float f2) {
        if (this.aLp != null) {
            try {
                this.aLp.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public void setLooping(boolean z) {
        if (this.aLp != null) {
            try {
                this.aLp.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isLooping() {
        if (this.aLp != null) {
            try {
                return this.aLp.isLooping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
