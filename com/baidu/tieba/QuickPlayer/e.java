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
    private IQuickMediaPlayer aWh;
    private g.a aWi;
    private g.InterfaceC0124g aWj;
    private g.b aWk;
    private g.c aWl;
    private g.e aWm;
    private g.h aWn;
    private g.f aWo;
    private g.j aWp;
    private g.d aWq;
    private g.i aWr;
    private b aWt;
    private Context mContext;
    private boolean aWu = false;
    private Handler.Callback aWv = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.KM().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.KM().b(e.this);
                e.this.a(e.this.aWh);
                e.this.aWh = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aWh);
            } else if (message.what == 4) {
                e.this.c(e.this.aWh);
            } else if (message.what == 5) {
                e.this.gi(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.KP();
            }
            return true;
        }
    };
    private Handler.Callback aWw = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aWj != null) {
                    e.this.aWj.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aWi != null) {
                    e.this.aWi.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.d.d)) {
                    com.baidu.tieba.play.d.d dVar = (com.baidu.tieba.play.d.d) message.obj;
                    if (e.this.aWk != null) {
                        e.this.aWk.onError(e.this, dVar.what, dVar.exT);
                    }
                    if (e.this.aWl != null) {
                        e.this.aWl.a(e.this, dVar.exS, dVar.what, dVar.exT);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aWm != null) {
                    e.this.aWm.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 11) {
                if (e.this.aWo != null) {
                    e.this.aWo.onReleaseFinished();
                }
            } else if (message.what == 12) {
                if (e.this.aWn != null) {
                    e.this.aWn.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.aWp != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.aWp.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.aWq != null && (message.obj instanceof String)) {
                    e.this.aWq.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.aWr != null && (message.obj instanceof Long)) {
                e.this.aWr.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.KL().getLooper(), this.aWv);
    private Handler aWs = new Handler(Looper.getMainLooper(), this.aWw);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hj(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Map<String, String> AC;
        this.aWt = bVar;
        try {
            this.aWh = d.KM().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.c.f.AB()) && (AC = com.baidu.tbadk.coreExtra.c.f.AC()) != null) {
                for (Map.Entry<String, String> entry : AC.entrySet()) {
                    this.aWh.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aWh.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bhg() == 0) | this.aWu);
            this.aWh.setListener(new PlayerListener(this.aWs));
            this.aWh.openVideo(this.aWt.getUri(), new Surface(this.aWt.getSurfaceTexture()), this.aWt.getHost());
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
        this.aWt = bVar;
        try {
            this.aWh = d.KM().createPlayer();
            this.aWh.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.bhg() == 0) | this.aWu);
            this.aWh.setListener(new PlayerListener(this.aWs));
            this.aWh.openVideo(this.aWt.getUri(), new Surface(this.aWt.getSurfaceTexture()), this.aWt.getHost());
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
    public void KP() {
        gi(getDuration());
    }

    @Override // com.baidu.tieba.play.g
    public void setOnPreparedListener(g.InterfaceC0124g interfaceC0124g) {
        this.aWj = interfaceC0124g;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aWi = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aWl = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aWm = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.f fVar) {
        this.aWo = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.h hVar) {
        this.aWn = hVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.j jVar) {
        this.aWp = jVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aWq = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.aWr = iVar;
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
        if (this.aWh != null) {
            try {
                return this.aWh.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aWh != null) {
            try {
                return this.aWh.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aWh != null) {
            try {
                return this.aWh.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aWh != null) {
            try {
                return this.aWh.getVideoHeight();
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
    public void gi(int i) {
        if (this.aWh != null) {
            try {
                this.aWh.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aWh != null) {
            try {
                return this.aWh.isPlaying();
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
        if (this.aWh != null) {
            try {
                this.aWh.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aWh != null) {
            try {
                this.aWh.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aWh != null) {
            try {
                return this.aWh.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aWu = z;
        try {
            this.aWh.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aWh != null) {
            try {
                if (this.aWh.isIjkPlayer()) {
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
    public void KO() {
        if (this.aWl != null) {
            this.aWl.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Hi() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aWs != null) {
            this.aWs.removeCallbacksAndMessages(null);
        }
    }
}
