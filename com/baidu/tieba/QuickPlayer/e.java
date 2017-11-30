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
    private IQuickMediaPlayer aZl;
    private g.a aZm;
    private g.f aZn;
    private g.b aZo;
    private g.c aZp;
    private g.e aZq;
    private g.InterfaceC0123g aZr;
    private g.i aZs;
    private g.d aZt;
    private g.h aZu;
    private b aZw;
    private Context mContext;
    private boolean aZx = false;
    private Handler.Callback aZy = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    d.Li().a(e.this);
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                d.Li().b(e.this);
                e.this.a(e.this.aZl);
                e.this.aZl = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aZl);
            } else if (message.what == 4) {
                e.this.c(e.this.aZl);
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
    private Handler.Callback aZz = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aZn != null) {
                    e.this.aZn.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aZm != null) {
                    e.this.aZm.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (message.obj != null && (message.obj instanceof com.baidu.tieba.play.b.d)) {
                    com.baidu.tieba.play.b.d dVar = (com.baidu.tieba.play.b.d) message.obj;
                    if (e.this.aZo != null) {
                        e.this.aZo.onError(e.this, dVar.what, dVar.fQH);
                    }
                    if (e.this.aZp != null) {
                        e.this.aZp.a(e.this, dVar.fQG, dVar.what, dVar.fQH);
                    }
                }
            } else if (message.what == 9) {
                if (e.this.aZq != null) {
                    e.this.aZq.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 12) {
                if (e.this.aZr != null) {
                    e.this.aZr.a(e.this);
                }
            } else if (message.what == 13) {
                if (e.this.aZs != null && ((message.obj instanceof String) || message.obj == null)) {
                    e.this.aZs.onSubError(message.arg1, message.arg2, (String) message.obj);
                }
            } else if (message.what == 14) {
                if (e.this.aZt != null && (message.obj instanceof String)) {
                    e.this.aZt.onHandleOppoError((String) message.obj);
                }
            } else if (message.what == 15 && e.this.aZu != null && (message.obj instanceof Long)) {
                e.this.aZu.onSpeed(((Long) message.obj).longValue());
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Lh().getLooper(), this.aZy);
    private Handler aZv = new Handler(Looper.getMainLooper(), this.aZz);

    @Override // com.baidu.tieba.play.g
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hm(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Map<String, String> AG;
        this.aZw = bVar;
        try {
            this.aZl = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AF()) && (AG = com.baidu.tbadk.coreExtra.model.f.AG()) != null) {
                for (Map.Entry<String, String> entry : AG.entrySet()) {
                    this.aZl.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZl.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biI() == 0) | this.aZx);
            this.aZl.setListener(new PlayerListener(this.aZv));
            this.aZl.openVideo(this.aZw.getUri(), new Surface(this.aZw.getSurfaceTexture()), this.aZw.getHost());
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
        Map<String, String> AG;
        this.aZw = bVar;
        try {
            this.aZl = d.Li().createPlayer();
            if (!StringUtils.isNull(com.baidu.tbadk.coreExtra.model.f.AF()) && (AG = com.baidu.tbadk.coreExtra.model.f.AG()) != null) {
                for (Map.Entry<String, String> entry : AG.entrySet()) {
                    this.aZl.setDebugParams(entry.getKey(), entry.getValue());
                }
            }
            this.aZl.forceUseSystemMediaPlayer((CustomPlayerSwitchStatic.biI() == 0) | this.aZx);
            this.aZl.setListener(new PlayerListener(this.aZv));
            this.aZl.openVideo(this.aZw.getUri(), new Surface(this.aZw.getSurfaceTexture()), this.aZw.getHost());
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
        this.aZn = fVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnCompletionListener(g.a aVar) {
        this.aZm = aVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.c cVar) {
        this.aZp = cVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.e eVar) {
        this.aZq = eVar;
    }

    @Override // com.baidu.tieba.play.g
    public void setOnSeekCompleteListener(g.InterfaceC0123g interfaceC0123g) {
        this.aZr = interfaceC0123g;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.i iVar) {
        this.aZs = iVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.d dVar) {
        this.aZt = dVar;
    }

    @Override // com.baidu.tieba.play.g
    public void a(g.h hVar) {
        this.aZu = hVar;
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
        if (this.aZl != null) {
            try {
                return this.aZl.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getCurrentPosition() {
        if (this.aZl != null) {
            try {
                return this.aZl.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int Ln() {
        if (this.aZl != null) {
            try {
                return this.aZl.getCachedPostion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getBitRate() {
        if (this.aZl != null) {
            try {
                return this.aZl.getBitRate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getCachedSize() {
        if (this.aZl != null) {
            try {
                return this.aZl.getCachedSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoWidth() {
        if (this.aZl != null) {
            try {
                return this.aZl.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.g
    public int getVideoHeight() {
        if (this.aZl != null) {
            try {
                return this.aZl.getVideoHeight();
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
        if (this.aZl != null) {
            try {
                this.aZl.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isPlaying() {
        if (this.aZl != null) {
            try {
                return this.aZl.isPlaying();
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
        if (this.aZl != null) {
            try {
                this.aZl.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public void setLooping(boolean z) {
        if (this.aZl != null) {
            try {
                this.aZl.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.g
    public boolean isExistInRemote() {
        if (this.aZl != null) {
            try {
                return this.aZl.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.g
    public void forceUseSystemMediaPlayer(boolean z) {
        this.aZx = z;
        try {
            this.aZl.forceUseSystemMediaPlayer(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.g
    public int getPlayerType() {
        if (this.aZl != null) {
            try {
                if (this.aZl.isIjkPlayer()) {
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
        if (this.aZp != null) {
            this.aZp.a(this, -300, -14399, -14399);
            TiebaStatic.log(new ak("c12197"));
        }
    }

    @Override // com.baidu.tieba.play.g
    public void Hp() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZv != null) {
            this.aZv.removeCallbacksAndMessages(null);
        }
    }
}
