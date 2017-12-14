package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.QuickPlayer.d;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.g;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements d.a, com.baidu.tieba.play.g {
    private static final String TAG = e.class.getSimpleName();
    private IQuickMediaPlayer aZn;
    private g.a aZo;
    private g.f aZp;
    private g.b aZq;
    private g.c aZr;
    private g.e aZs;
    private g.InterfaceC0138g aZt;
    private g.i aZu;
    private g.d aZv;
    private g.h aZw;
    private b aZy;
    private Context mContext;
    private boolean aZz = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Li().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Li().b(e.this);
                e.this.a(e.this.aZn);
                e.this.aZn = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aZn);
            } else if (message.what == 4) {
                e.this.c(e.this.aZn);
            } else if (message.what == 5) {
                e.this.gq(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Lm();
            }
            return true;
        }
    };
    private Handler.Callback aZA = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aZp != null) {
                    e.this.aZp.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aZo != null) {
                    e.this.aZo.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.aZq != null) {
                        e.this.aZq.onError(e.this, dVar.what, dVar.fRA);
                    }
                    if (e.this.aZr != null) {
                        e.this.aZr.a(e.this, dVar.fRz, dVar.what, dVar.fRA);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aZs != null) {
                    e.this.aZs.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.aZt != null) {
                    e.this.aZt.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.aZu != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.aZu.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.aZv != null && (message.obj instanceof String)) {
                    e.this.aZv.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.aZw != null && (message.obj instanceof Long)) {
                e.this.aZw.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Lh().getLooper(), this.mHandlerCallback);
    private Handler aZx = new Handler(Looper.getMainLooper(), this.aZA);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hk(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Map<String, String> AH;
        this.aZy = bVar;
        try {
            this.aZn = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AG()) && (AH = com.baidu.tbadk.coreExtra.model.f.AH()) != null) {
                for (Map.Entry<String, String> entry : AH.entrySet()) {
                    this.aZn.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZn.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biQ() == 0) | this.aZz);
            this.aZn.setListener(new PlayerListener(this.aZx));
            this.aZn.openVideo(this.aZy.getUri(), new Surface(this.aZy.getSurfaceTexture()), this.aZy.getHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public void release() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, int i) {
        Map<String, String> AH;
        this.aZy = bVar;
        try {
            this.aZn = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AG()) && (AH = com.baidu.tbadk.coreExtra.model.f.AH()) != null) {
                for (Map.Entry<String, String> entry : AH.entrySet()) {
                    this.aZn.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZn.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biQ() == 0) | this.aZz);
            this.aZn.setListener(new PlayerListener(this.aZx));
            this.aZn.openVideo(this.aZy.getUri(), new Surface(this.aZy.getSurfaceTexture()), this.aZy.getHost());
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
    public void Lm() {
        gq(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.f fVar) {
        this.aZp = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aZo = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aZr = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aZs = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0138g interfaceC0138g) {
        this.aZt = interfaceC0138g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.aZu = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aZv = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.aZw = hVar;
    }

    @Override // com.baidu.tieba.play.g
    public void start() {
        if (this.mHandler.hasMessages(4)) {
            this.mHandler.removeMessages(4);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void pause() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IQuickMediaPlayer iQuickMediaPlayer) {
        if (iQuickMediaPlayer != null) {
            try {
                iQuickMediaPlayer.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getDuration() {
        if (this.aZn != null) {
            try {
                return this.aZn.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aZn != null) {
            try {
                return this.aZn.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int Ln() {
        if (this.aZn != null) {
            try {
                return this.aZn.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.aZn != null) {
            try {
                return this.aZn.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.aZn != null) {
            try {
                return this.aZn.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aZn != null) {
            try {
                return this.aZn.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aZn != null) {
            try {
                return this.aZn.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gq(int i) {
        if (this.aZn != null) {
            try {
                this.aZn.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aZn != null) {
            try {
                return this.aZn.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = bVar;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.baidu.tieba.play.g
    public void setVolume(float f, float f2) {
        if (this.aZn != null) {
            try {
                this.aZn.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aZn != null) {
            try {
                this.aZn.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aZn != null) {
            try {
                return this.aZn.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aZz = z;
        try {
            this.aZn.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aZn != null) {
            try {
                if (this.aZn.isIjkPlayer()) {
                    return SapiErrorCode.NETWORK_FAILED;
                }
                return -100;
            } catch (Exception e) {
                e.printStackTrace();
                return -300;
            }
        }
        return -300;
    }

    @Override // com.baidu.tieba.QuickPlayer.d.a
    public void Ll() {
        if (this.aZr != null) {
            this.aZr.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Hq() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZx != null) {
            this.aZx.removeCallbacksAndMessages(null);
        }
    }
}
