package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.f;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.play.f {
    private static final String TAG = e.class.getSimpleName();
    private b aUB;
    private IQuickMediaPlayer aUu;
    private f.a aUv;
    private f.e aUw;
    private f.b aUx;
    private f.c aUy;
    private f.d aUz;
    private Context mContext;
    private Handler.Callback aUC = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj);
                }
            } else if (message.what == 2) {
                e.this.a(e.this.aUu);
                e.this.aUu = null;
            } else if (message.what == 3) {
                e.this.b(e.this.aUu);
            } else if (message.what == 4) {
                e.this.c(e.this.aUu);
            } else if (message.what == 5) {
                e.this.fN(message.arg1);
            } else if (message.what == 10) {
                if (message.obj instanceof b) {
                    e.this.a((b) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                e.this.Kj();
            }
            return true;
        }
    };
    private Handler.Callback aUD = new Handler.Callback() { // from class: com.baidu.tieba.QuickPlayer.e.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 6) {
                if (e.this.aUw != null) {
                    e.this.aUw.onPrepared(e.this);
                }
            } else if (message.what == 7) {
                if (e.this.aUv != null) {
                    e.this.aUv.onCompletion(e.this);
                }
            } else if (message.what == 8) {
                if (e.this.aUx == null || !e.this.aUx.onError(e.this, message.arg1, message.arg2)) {
                }
            } else if (message.what == 9) {
                if (e.this.aUy != null) {
                    e.this.aUy.a(e.this, message.arg1, message.arg2);
                }
            } else if (message.what == 11 && e.this.aUz != null) {
                e.this.aUz.onReleaseFinished();
            }
            return true;
        }
    };
    private Handler mHandler = new Handler(c.Kg().getLooper(), this.aUC);
    private Handler aUA = new Handler(Looper.getMainLooper(), this.aUD);

    @Override // com.baidu.tieba.play.f
    public void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str) {
        this.mContext = context;
        b bVar = new b();
        bVar.setUri(uri);
        bVar.setHeaders(map);
        bVar.b(surfaceTexture);
        bVar.hd(str);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.aUB = bVar;
        try {
            this.aUu = d.Kh().createPlayer();
            this.aUu.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfk() == 0);
            this.aUu.setListener(new PlayerListener(this.aUA));
            this.aUu.openVideo(this.aUB.getUri(), new Surface(this.aUB.getSurfaceTexture()), this.aUB.getHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.play.f
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
        this.aUB = bVar;
        try {
            this.aUu = d.Kh().createPlayer();
            this.aUu.forceUseSystemMediaPlayer(CustomPlayerSwitchStatic.bfk() == 0);
            this.aUu.setListener(new PlayerListener(this.aUA));
            this.aUu.openVideo(this.aUB.getUri(), new Surface(this.aUB.getSurfaceTexture()), this.aUB.getHost());
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
    public void Kj() {
        fN(getDuration());
    }

    @Override // com.baidu.tieba.play.f
    public void setOnPreparedListener(f.e eVar) {
        this.aUw = eVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnCompletionListener(f.a aVar) {
        this.aUv = aVar;
    }

    @Override // com.baidu.tieba.play.f
    public void setOnErrorListener(f.b bVar) {
        this.aUx = bVar;
    }

    @Override // com.baidu.tieba.play.f
    public void a(f.c cVar) {
        this.aUy = cVar;
    }

    @Override // com.baidu.tieba.play.f
    public void a(f.d dVar) {
        this.aUz = dVar;
    }

    @Override // com.baidu.tieba.play.f
    public void start() {
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

    @Override // com.baidu.tieba.play.f
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

    @Override // com.baidu.tieba.play.f
    public int getDuration() {
        if (this.aUu != null) {
            try {
                return this.aUu.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.aUu != null) {
            try {
                return this.aUu.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoWidth() {
        if (this.aUu != null) {
            try {
                return this.aUu.getVideoWidth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public int getVideoHeight() {
        if (this.aUu != null) {
            try {
                return this.aUu.getVideoHeight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.f
    public void seekTo(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(int i) {
        if (this.aUu != null) {
            try {
                this.aUu.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.aUu != null) {
            try {
                return this.aUu.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.f
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

    @Override // com.baidu.tieba.play.f
    public void setVolume(float f, float f2) {
        if (this.aUu != null) {
            try {
                this.aUu.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public void setLooping(boolean z) {
        if (this.aUu != null) {
            try {
                this.aUu.setLooping(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isLooping() {
        if (this.aUu != null) {
            try {
                return this.aUu.isLooping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isExistInRemote() {
        if (this.aUu != null) {
            try {
                return this.aUu.isExistInRemote();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
