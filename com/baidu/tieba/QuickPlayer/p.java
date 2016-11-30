package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.t;
import java.util.Map;
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.play.t {
    private static final String TAG = p.class.getSimpleName();
    private b aMm;
    private t.a aMn;
    private t.d aMo;
    private t.b aMp;
    private t.c aMq;
    private e aMs;
    private Context mContext;
    private Handler.Callback aMt = new q(this);
    private Handler.Callback aMu = new r(this);
    private Handler mHandler = new Handler(f.Jn().getLooper(), this.aMt);
    private Handler aMr = new Handler(Looper.getMainLooper(), this.aMu);

    @Override // com.baidu.tieba.play.t
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
        this.aMs = eVar;
        try {
            this.aMm = m.Jq().Jm();
            this.aMm.ce(CustomPlayerSwitchStatic.bcp() == 0);
            this.aMm.a(new g(this.aMr));
            this.aMm.a(this.aMs.getUri(), new Surface(this.aMs.getSurfaceTexture()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.t
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

    @Override // com.baidu.tieba.play.t
    public void setOnPreparedListener(t.d dVar) {
        this.aMo = dVar;
    }

    @Override // com.baidu.tieba.play.t
    public void setOnCompletionListener(t.a aVar) {
        this.aMn = aVar;
    }

    @Override // com.baidu.tieba.play.t
    public void setOnErrorListener(t.b bVar) {
        this.aMp = bVar;
    }

    @Override // com.baidu.tieba.play.t
    public void a(t.c cVar) {
        this.aMq = cVar;
    }

    @Override // com.baidu.tieba.play.t
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

    @Override // com.baidu.tieba.play.t
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

    @Override // com.baidu.tieba.play.t
    public int getDuration() {
        if (this.aMm != null) {
            try {
                return this.aMm.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getCurrentPosition() {
        if (this.aMm != null) {
            try {
                return this.aMm.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getVideoWidth() {
        if (this.aMm != null) {
            try {
                return this.aMm.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getVideoHeight() {
        if (this.aMm != null) {
            try {
                return this.aMm.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(int i) {
        if (this.aMm != null) {
            try {
                this.aMm.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.t
    public boolean isPlaying() {
        if (this.aMm != null) {
            try {
                return this.aMm.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.t
    public void setVolume(float f, float f2) {
        if (this.aMm != null) {
            try {
                this.aMm.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.t
    public boolean isLooping() {
        if (this.aMm != null) {
            try {
                return this.aMm.isLooping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
