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
    private b aQG;
    private v.a aQH;
    private v.d aQI;
    private v.b aQJ;
    private v.c aQK;
    private e aQM;
    private Context mContext;
    private Handler.Callback aQN = new q(this);
    private Handler.Callback aQO = new r(this);
    private Handler mHandler = new Handler(f.Ka().getLooper(), this.aQN);
    private Handler aQL = new Handler(Looper.getMainLooper(), this.aQO);

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
        this.aQM = eVar;
        try {
            this.aQG = m.Kd().JZ();
            this.aQG.ci(CustomPlayerSwitchStatic.aXK() == 0);
            this.aQG.a(new g(this.aQL));
            this.aQG.a(this.aQM.getUri(), new Surface(this.aQM.getSurfaceTexture()));
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
        this.aQM = eVar;
        try {
            this.aQG = m.Kd().JZ();
            this.aQG.ci(CustomPlayerSwitchStatic.aXK() == 0);
            this.aQG.a(new g(this.aQL));
            this.aQG.a(this.aQM.getUri(), new Surface(this.aQM.getSurfaceTexture()));
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
    public void Kf() {
        fH(getDuration());
    }

    @Override // com.baidu.tieba.play.v
    public void setOnPreparedListener(v.d dVar) {
        this.aQI = dVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnCompletionListener(v.a aVar) {
        this.aQH = aVar;
    }

    @Override // com.baidu.tieba.play.v
    public void setOnErrorListener(v.b bVar) {
        this.aQJ = bVar;
    }

    @Override // com.baidu.tieba.play.v
    public void a(v.c cVar) {
        this.aQK = cVar;
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
        if (this.aQG != null) {
            try {
                return this.aQG.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getCurrentPosition() {
        if (this.aQG != null) {
            try {
                return this.aQG.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoWidth() {
        if (this.aQG != null) {
            try {
                return this.aQG.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.v
    public int getVideoHeight() {
        if (this.aQG != null) {
            try {
                return this.aQG.getVideoHeight();
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
        if (this.aQG != null) {
            try {
                this.aQG.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean isPlaying() {
        if (this.aQG != null) {
            try {
                return this.aQG.isPlaying();
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
        if (this.aQG != null) {
            try {
                this.aQG.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public void setLooping(boolean z) {
        if (this.aQG != null) {
            try {
                this.aQG.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.v
    public boolean JW() {
        if (this.aQG != null) {
            try {
                return this.aQG.JW();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
