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
    private b aRb;
    private v.a aRc;
    private v.d aRd;
    private v.b aRe;
    private v.c aRf;
    private e aRh;
    private Context mContext;
    private Handler.Callback aRi = new q(this);
    private Handler.Callback aRj = new r(this);
    private Handler mHandler = new Handler(f.Jo().getLooper(), this.aRi);
    private Handler aRg = new Handler(Looper.getMainLooper(), this.aRj);

    @Override // com.baidu.tieba.play.v
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture) {
        this.mContext = context;
        e eVar = new e();
        eVar.setUri(uri);
        eVar.setHeaders(map);
        eVar.b(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = eVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        this.aRh = eVar;
        try {
            this.aRb = m.Jr().Jn();
            this.aRb.ck(CustomPlayerSwitchStatic.aWk() == 0);
            this.aRb.a(new g(this.aRg));
            this.aRb.a(this.aRh.getUri(), new Surface(this.aRh.getSurfaceTexture()));
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
        this.aRh = eVar;
        try {
            this.aRb = m.Jr().Jn();
            this.aRb.ck(CustomPlayerSwitchStatic.aWk() == 0);
            this.aRb.a(new g(this.aRg));
            this.aRb.a(this.aRh.getUri(), new Surface(this.aRh.getSurfaceTexture()));
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
    public void Jt() {
        fE(getDuration());
    }

    @Override // com.baidu.tieba.play.v
    public void setOnPreparedListener(v.d dVar) {
        this.aRd = dVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnCompletionListener(v.a aVar) {
        this.aRc = aVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnErrorListener(v.b bVar) {
        this.aRe = bVar;
    }

    @Override // com.baidu.tieba.play.v
    public void a(v.c cVar) {
        this.aRf = cVar;
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
        if (this.aRb != null) {
            try {
                return this.aRb.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getCurrentPosition() {
        if (this.aRb != null) {
            try {
                return this.aRb.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoWidth() {
        if (this.aRb != null) {
            try {
                return this.aRb.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoHeight() {
        if (this.aRb != null) {
            try {
                return this.aRb.getVideoHeight();
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
    public void fE(int i) {
        if (this.aRb != null) {
            try {
                this.aRb.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isPlaying() {
        if (this.aRb != null) {
            try {
                return this.aRb.isPlaying();
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
        eVar.b(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = eVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.v
    public void setVolume(float f, float f2) {
        if (this.aRb != null) {
            try {
                this.aRb.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void setLooping(boolean z) {
        if (this.aRb != null) {
            try {
                this.aRb.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean Jk() {
        if (this.aRb != null) {
            try {
                return this.aRb.Jk();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
