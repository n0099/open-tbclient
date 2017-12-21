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
    private g.h aZA;
    private b aZC;
    private IQuickMediaPlayer aZr;
    private g.a aZs;
    private g.f aZt;
    private g.b aZu;
    private g.c aZv;
    private g.e aZw;
    private g.InterfaceC0137g aZx;
    private g.i aZy;
    private g.d aZz;
    private Context mContext;
    private boolean aZD = false;
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
                e.this.a(e.this.aZr);
                e.this.aZr = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aZr);
            } else if (message.what == 4) {
                e.this.c(e.this.aZr);
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
    private Handler.Callback aZE = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aZt != null) {
                    e.this.aZt.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aZs != null) {
                    e.this.aZs.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.aZu != null) {
                        e.this.aZu.onError(e.this, dVar.what, dVar.fRF);
                    }
                    if (e.this.aZv != null) {
                        e.this.aZv.a(e.this, dVar.fRE, dVar.what, dVar.fRF);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aZw != null) {
                    e.this.aZw.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.aZx != null) {
                    e.this.aZx.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.aZy != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.aZy.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.aZz != null && (message.obj instanceof String)) {
                    e.this.aZz.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.aZA != null && (message.obj instanceof Long)) {
                e.this.aZA.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Lh().getLooper(), this.mHandlerCallback);
    private Handler aZB = new Handler(Looper.getMainLooper(), this.aZE);

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
        this.aZC = bVar;
        try {
            this.aZr = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AG()) && (AH = com.baidu.tbadk.coreExtra.model.f.AH()) != null) {
                for (Map.Entry<String, String> entry : AH.entrySet()) {
                    this.aZr.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZr.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biQ() == 0) | this.aZD);
            this.aZr.setListener(new PlayerListener(this.aZB));
            this.aZr.openVideo(this.aZC.getUri(), new Surface(this.aZC.getSurfaceTexture()), this.aZC.getHost());
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
        this.aZC = bVar;
        try {
            this.aZr = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AG()) && (AH = com.baidu.tbadk.coreExtra.model.f.AH()) != null) {
                for (Map.Entry<String, String> entry : AH.entrySet()) {
                    this.aZr.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZr.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biQ() == 0) | this.aZD);
            this.aZr.setListener(new PlayerListener(this.aZB));
            this.aZr.openVideo(this.aZC.getUri(), new Surface(this.aZC.getSurfaceTexture()), this.aZC.getHost());
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
        this.aZt = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aZs = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aZv = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aZw = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0137g interfaceC0137g) {
        this.aZx = interfaceC0137g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.aZy = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aZz = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.aZA = hVar;
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
        if (this.aZr != null) {
            try {
                return this.aZr.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aZr != null) {
            try {
                return this.aZr.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int Ln() {
        if (this.aZr != null) {
            try {
                return this.aZr.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.aZr != null) {
            try {
                return this.aZr.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.aZr != null) {
            try {
                return this.aZr.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aZr != null) {
            try {
                return this.aZr.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aZr != null) {
            try {
                return this.aZr.getVideoHeight();
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
        if (this.aZr != null) {
            try {
                this.aZr.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aZr != null) {
            try {
                return this.aZr.isPlaying();
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
        if (this.aZr != null) {
            try {
                this.aZr.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aZr != null) {
            try {
                this.aZr.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aZr != null) {
            try {
                return this.aZr.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aZD = z;
        try {
            this.aZr.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aZr != null) {
            try {
                if (this.aZr.isIjkPlayer()) {
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
        if (this.aZv != null) {
            this.aZv.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Hq() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZB != null) {
            this.aZB.removeCallbacksAndMessages(null);
        }
    }
}
