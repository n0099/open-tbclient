package com.baidu.tieba.aiapps.apps.widget;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.r.e.b.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes12.dex */
public class b implements com.baidu.swan.apps.r.e.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean egw = false;
    private String bAy;
    private MediaPlayer bbi;
    private String bch;
    private a.InterfaceC0277a bxg;
    private AudioManager bxi;
    private ZeusPluginFactory.Invoker egx;
    private Context mContext;
    private boolean bEd = false;
    private boolean egy = false;
    private final MediaPlayer.OnPreparedListener ckx = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bxg != null) {
                b.this.bxg.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener ckz = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.HB();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bxg != null) {
                b.this.bxg.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener cky = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.HB();
            if (b.this.bxg != null) {
                if (z) {
                    b.this.bxg.onEnded();
                } else {
                    b.this.bxg.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dVu = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bxg.fd(i);
            if (i == 3) {
                b.this.bbq();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener egz = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener ckA = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dVt = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bxg != null) {
                b.this.bxg.TD();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bnB = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1) {
                b.this.pause();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public interface a {
        void hM(boolean z);
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        this.egx = invoker;
        if (this.egx != null) {
            this.mContext = com.baidu.swan.apps.w.a.TU();
            this.bAy = (String) this.egx.get("id");
        }
        this.bch = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.TU(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void hM(boolean z) {
                aVar.cF(z);
            }
        });
    }

    private synchronized MediaPlayer Hz() {
        if (this.bbi == null) {
            this.bbi = new MediaPlayer();
            this.bbi.setOnPreparedListener(this.ckx);
            this.bbi.setOnVideoSizeChangedListener(this.dVt);
            this.bbi.setOnCompletionListener(this.cky);
            this.bbi.setOnErrorListener(this.ckz);
            this.bbi.setOnInfoListener(this.dVu);
            this.bbi.setOnBufferingUpdateListener(this.egz);
            this.bbi.setOnSeekCompleteListener(this.ckA);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bbi.hashCode() + " 已创建");
            }
        }
        return this.bbi;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean c(String str, String str2, String str3, boolean z) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.egy = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String js = js(str);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SM.COOKIE, str2);
        }
        if (z) {
            hashMap.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("User-Agent", str3);
        }
        try {
            Hz().setDataSource(this.mContext, Uri.parse(js), hashMap);
            return true;
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", "setDataSource fail");
                return true;
            }
            return true;
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSurface(Surface surface) {
        Hz().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        HA();
        Hz().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAy + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        HA();
        Hz().start();
        hL(true);
        if (this.bxg != null) {
            this.bxg.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAy + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        Hz().pause();
        hL(false);
        if (this.bxg != null) {
            this.bxg.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        Hz().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAy + " release()");
        }
        HB();
        Hz().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return Hz().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return Hz().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return Hz().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return Hz().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return Hz().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void cG(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TE() {
        if (isPlaying()) {
            this.bEd = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TF() {
        if (!isPlaying() && this.bEd) {
            this.bEd = false;
            start();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setMuted(boolean z) {
        setVolume(z ? 0.0f : 1.0f);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void m(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void a(@NonNull a.InterfaceC0277a interfaceC0277a) {
        this.bxg = interfaceC0277a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean TG() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Ts() {
        return this.bAy;
    }

    private void HA() {
        if (this.bxi == null) {
            this.bxi = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxi != null) {
            try {
                this.bxi.requestAudioFocus(this.bnB, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (Hz() != null) {
            Hz().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!egw && aVar != null) {
            aVar.hM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bxi == null) {
            this.bxi = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxi != null) {
            this.bxi.abandonAudioFocus(this.bnB);
        }
    }

    private void hL(final boolean z) {
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e acD = e.acD();
                if (acD != null && (activity = acD.getActivity()) != null && (window = activity.getWindow()) != null) {
                    try {
                        if (z) {
                            window.addFlags(128);
                        } else {
                            window.clearFlags(128);
                        }
                    } catch (Exception e) {
                        if (b.DEBUG) {
                            throw new RuntimeException("inline video set screenOn/Off in wrong thread", e);
                        }
                    }
                    if (b.DEBUG) {
                        Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + z);
                    }
                }
            }
        });
    }

    private static String js(String str) {
        e acD = e.acD();
        return (!com.baidu.swan.apps.storage.b.lS(str) || acD == null) ? str : com.baidu.swan.apps.storage.b.d(str, acD);
    }

    public void bbq() {
    }

    public void h(int i, int i2, String str) {
    }
}
