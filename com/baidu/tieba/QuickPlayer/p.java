package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.v;
import java.util.Map;
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.play.v {
    private static final String TAG = p.class.getSimpleName();
    private b aKF;
    private v.a aKG;
    private v.d aKH;
    private v.b aKI;
    private v.c aKJ;
    private e aKL;
    private Context mContext;
    private Handler.Callback aKM = new q(this);
    private Handler.Callback aKN = new r(this);
    private Handler mHandler = new Handler(f.IV().getLooper(), this.aKM);
    private Handler aKK = new Handler(Looper.getMainLooper(), this.aKN);

    @Override // com.baidu.tieba.play.v
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture) {
        this.mContext = context;
        e eVar = new e();
        eVar.setUri(uri);
        eVar.setHeaders(map);
        eVar.a(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = eVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        this.aKL = eVar;
        try {
            this.aKF = m.IY().IU();
            this.aKF.ch(CustomPlayerSwitchStatic.aXX() == 0);
            this.aKF.a(new g(this.aKK));
            this.aKF.a(this.aKL.getUri(), new Surface(this.aKL.getSurfaceTexture()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.v
    public void release() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null) {
            try {
                bVar.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, int i) {
        this.aKL = eVar;
        try {
            this.aKF = m.IY().IU();
            this.aKF.ch(CustomPlayerSwitchStatic.aXX() == 0);
            this.aKF.a(new g(this.aKK));
            this.aKF.a(this.aKL.getUri(), new Surface(this.aKL.getSurfaceTexture()));
            if (i == 3) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
            } else if (i == 2) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        fK(getDuration());
    }

    @Override // com.baidu.tieba.play.v
    public void setOnPreparedListener(v.d dVar) {
        this.aKH = dVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnCompletionListener(v.a aVar) {
        this.aKG = aVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnErrorListener(v.b bVar) {
        this.aKI = bVar;
    }

    @Override // com.baidu.tieba.play.v
    public void a(v.c cVar) {
        this.aKJ = cVar;
    }

    @Override // com.baidu.tieba.play.v
    public void start() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar != null) {
            try {
                bVar.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void pause() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (bVar != null) {
            try {
                bVar.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public int getDuration() {
        if (this.aKF != null) {
            try {
                return this.aKF.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getCurrentPosition() {
        if (this.aKF != null) {
            try {
                return this.aKF.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoWidth() {
        if (this.aKF != null) {
            try {
                return this.aKF.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoHeight() {
        if (this.aKF != null) {
            try {
                return this.aKF.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(int i) {
        if (this.aKF != null) {
            try {
                this.aKF.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isPlaying() {
        if (this.aKF != null) {
            try {
                return this.aKF.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.v
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i) {
        this.mContext = context;
        e eVar = new e();
        eVar.setUri(uri);
        eVar.setHeaders(map);
        eVar.a(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = eVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.v
    public void setVolume(float f, float f2) {
        if (this.aKF != null) {
            try {
                this.aKF.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void setLooping(boolean z) {
        if (this.aKF != null) {
            try {
                this.aKF.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isLooping() {
        if (this.aKF != null) {
            try {
                return this.aKF.isLooping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.v
    public boolean IR() {
        if (this.aKF != null) {
            try {
                return this.aKF.IR();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
