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
    private e aSB;
    private b aSv;
    private v.a aSw;
    private v.d aSx;
    private v.b aSy;
    private v.c aSz;
    private Context mContext;
    private Handler.Callback aSC = new q(this);
    private Handler.Callback aSD = new r(this);
    private Handler mHandler = new Handler(f.JJ().getLooper(), this.aSC);
    private Handler aSA = new Handler(Looper.getMainLooper(), this.aSD);

    @Override // com.baidu.tieba.play.v
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        e eVar = new e();
        eVar.setUri(uri);
        eVar.setHeaders(map);
        eVar.b(surfaceTexture);
        eVar.gT(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = eVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        this.aSB = eVar;
        try {
            this.aSv = m.JM().JI();
            this.aSv.cj(CustomPlayerSwitchStatic.bbM() == 0);
            this.aSv.a(new g(this.aSA));
            this.aSv.a(this.aSB.getUri(), new Surface(this.aSB.getSurfaceTexture()), this.aSB.getHost());
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
        this.aSB = eVar;
        try {
            this.aSv = m.JM().JI();
            this.aSv.cj(CustomPlayerSwitchStatic.bbM() == 0);
            this.aSv.a(new g(this.aSA));
            this.aSv.a(this.aSB.getUri(), new Surface(this.aSB.getSurfaceTexture()), this.aSB.getHost());
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
    public void JO() {
        fH(getDuration());
    }

    @Override // com.baidu.tieba.play.v
    public void setOnPreparedListener(v.d dVar) {
        this.aSx = dVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnCompletionListener(v.a aVar) {
        this.aSw = aVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnErrorListener(v.b bVar) {
        this.aSy = bVar;
    }

    @Override // com.baidu.tieba.play.v
    public void a(v.c cVar) {
        this.aSz = cVar;
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
        if (this.aSv != null) {
            try {
                return this.aSv.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getCurrentPosition() {
        if (this.aSv != null) {
            try {
                return this.aSv.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoWidth() {
        if (this.aSv != null) {
            try {
                return this.aSv.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoHeight() {
        if (this.aSv != null) {
            try {
                return this.aSv.getVideoHeight();
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
    public void fH(int i) {
        if (this.aSv != null) {
            try {
                this.aSv.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isPlaying() {
        if (this.aSv != null) {
            try {
                return this.aSv.isPlaying();
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
        if (this.aSv != null) {
            try {
                this.aSv.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void setLooping(boolean z) {
        if (this.aSv != null) {
            try {
                this.aSv.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean JF() {
        if (this.aSv != null) {
            try {
                return this.aSv.JF();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
