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
    private b aLD;
    private t.a aLE;
    private t.d aLF;
    private t.b aLG;
    private t.c aLH;
    private e aLJ;
    private Context mContext;
    private Handler.Callback aLK = new q(this);
    private Handler.Callback aLL = new r(this);
    private Handler mHandler = new Handler(f.II().getLooper(), this.aLK);
    private Handler aLI = new Handler(Looper.getMainLooper(), this.aLL);

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
        this.aLJ = eVar;
        try {
            this.aLD = m.IL().IH();
            this.aLD.cd(CustomPlayerSwitchStatic.aWa() == 0);
            this.aLD.a(new g(this.aLI));
            this.aLD.a(this.aLJ.getUri(), new Surface(this.aLJ.getSurfaceTexture()));
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
        this.aLF = dVar;
    }

    @Override // com.baidu.tieba.play.t
    public void setOnCompletionListener(t.a aVar) {
        this.aLE = aVar;
    }

    @Override // com.baidu.tieba.play.t
    public void setOnErrorListener(t.b bVar) {
        this.aLG = bVar;
    }

    @Override // com.baidu.tieba.play.t
    public void a(t.c cVar) {
        this.aLH = cVar;
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
        if (this.aLD != null) {
            try {
                return this.aLD.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getCurrentPosition() {
        if (this.aLD != null) {
            try {
                return this.aLD.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getVideoWidth() {
        if (this.aLD != null) {
            try {
                return this.aLD.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.t
    public int getVideoHeight() {
        if (this.aLD != null) {
            try {
                return this.aLD.getVideoHeight();
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
    public void fG(int i) {
        if (this.aLD != null) {
            try {
                this.aLD.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.t
    public boolean isPlaying() {
        if (this.aLD != null) {
            try {
                return this.aLD.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.t
    public void setVolume(float f, float f2) {
        if (this.aLD != null) {
            try {
                this.aLD.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.t
    public boolean isLooping() {
        if (this.aLD != null) {
            try {
                return this.aLD.isLooping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
