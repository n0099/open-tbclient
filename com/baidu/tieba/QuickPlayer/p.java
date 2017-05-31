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
    private b aRc;
    private v.a aRd;
    private v.d aRe;
    private v.b aRf;
    private v.c aRg;
    private e aRi;
    private Context mContext;
    private Handler.Callback aRj = new q(this);
    private Handler.Callback aRk = new r(this);
    private Handler mHandler = new Handler(f.Jl().getLooper(), this.aRj);
    private Handler aRh = new Handler(Looper.getMainLooper(), this.aRk);

    @Override // com.baidu.tieba.play.v
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        e eVar = new e();
        eVar.setUri(uri);
        eVar.setHeaders(map);
        eVar.b(surfaceTexture);
        eVar.gw(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = eVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        this.aRi = eVar;
        try {
            this.aRc = m.Jo().Jk();
            this.aRc.ch(CustomPlayerSwitchStatic.aXB() == 0);
            this.aRc.a(new g(this.aRh));
            this.aRc.a(this.aRi.getUri(), new Surface(this.aRi.getSurfaceTexture()), this.aRi.getHost());
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
        this.aRi = eVar;
        try {
            this.aRc = m.Jo().Jk();
            this.aRc.ch(CustomPlayerSwitchStatic.aXB() == 0);
            this.aRc.a(new g(this.aRh));
            this.aRc.a(this.aRi.getUri(), new Surface(this.aRi.getSurfaceTexture()), this.aRi.getHost());
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
    public void Jq() {
        fF(getDuration());
    }

    @Override // com.baidu.tieba.play.v
    public void setOnPreparedListener(v.d dVar) {
        this.aRe = dVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnCompletionListener(v.a aVar) {
        this.aRd = aVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnErrorListener(v.b bVar) {
        this.aRf = bVar;
    }

    @Override // com.baidu.tieba.play.v
    public void a(v.c cVar) {
        this.aRg = cVar;
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
        if (this.aRc != null) {
            try {
                return this.aRc.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getCurrentPosition() {
        if (this.aRc != null) {
            try {
                return this.aRc.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoWidth() {
        if (this.aRc != null) {
            try {
                return this.aRc.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoHeight() {
        if (this.aRc != null) {
            try {
                return this.aRc.getVideoHeight();
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
    public void fF(int i) {
        if (this.aRc != null) {
            try {
                this.aRc.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isPlaying() {
        if (this.aRc != null) {
            try {
                return this.aRc.isPlaying();
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
        if (this.aRc != null) {
            try {
                this.aRc.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void setLooping(boolean z) {
        if (this.aRc != null) {
            try {
                this.aRc.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean Jh() {
        if (this.aRc != null) {
            try {
                return this.aRc.Jh();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
