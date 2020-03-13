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
    private static boolean egK = false;
    private String bAA;
    private MediaPlayer bbk;
    private String bcj;
    private a.InterfaceC0277a bxi;
    private AudioManager bxk;
    private ZeusPluginFactory.Invoker egL;
    private Context mContext;
    private boolean bEf = false;
    private boolean egM = false;
    private final MediaPlayer.OnPreparedListener ckz = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bxi != null) {
                b.this.bxi.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener ckB = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.HD();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bxi != null) {
                b.this.bxi.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener ckA = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.HD();
            if (b.this.bxi != null) {
                if (z) {
                    b.this.bxi.onEnded();
                } else {
                    b.this.bxi.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dVI = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bxi.fd(i);
            if (i == 3) {
                b.this.bbt();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener egN = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener ckC = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dVH = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bxi != null) {
                b.this.bxi.TF();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bnD = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
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
        this.egL = invoker;
        if (this.egL != null) {
            this.mContext = com.baidu.swan.apps.w.a.TW();
            this.bAA = (String) this.egL.get("id");
        }
        this.bcj = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.TW(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void hM(boolean z) {
                aVar.cF(z);
            }
        });
    }

    private synchronized MediaPlayer HB() {
        if (this.bbk == null) {
            this.bbk = new MediaPlayer();
            this.bbk.setOnPreparedListener(this.ckz);
            this.bbk.setOnVideoSizeChangedListener(this.dVH);
            this.bbk.setOnCompletionListener(this.ckA);
            this.bbk.setOnErrorListener(this.ckB);
            this.bbk.setOnInfoListener(this.dVI);
            this.bbk.setOnBufferingUpdateListener(this.egN);
            this.bbk.setOnSeekCompleteListener(this.ckC);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bbk.hashCode() + " 已创建");
            }
        }
        return this.bbk;
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
        this.egM = true;
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
            HB().setDataSource(this.mContext, Uri.parse(js), hashMap);
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
        HB().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        HC();
        HB().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        HC();
        HB().start();
        hL(true);
        if (this.bxi != null) {
            this.bxi.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        HB().pause();
        hL(false);
        if (this.bxi != null) {
            this.bxi.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        HB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAA + " release()");
        }
        HD();
        HB().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return HB().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return HB().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return HB().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return HB().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return HB().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void cG(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TG() {
        if (isPlaying()) {
            this.bEf = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TH() {
        if (!isPlaying() && this.bEf) {
            this.bEf = false;
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
        this.bxi = interfaceC0277a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean TI() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Tu() {
        return this.bAA;
    }

    private void HC() {
        if (this.bxk == null) {
            this.bxk = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxk != null) {
            try {
                this.bxk.requestAudioFocus(this.bnD, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (HB() != null) {
            HB().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!egK && aVar != null) {
            aVar.hM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bxk == null) {
            this.bxk = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxk != null) {
            this.bxk.abandonAudioFocus(this.bnD);
        }
    }

    private void hL(final boolean z) {
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e acF = e.acF();
                if (acF != null && (activity = acF.getActivity()) != null && (window = activity.getWindow()) != null) {
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
        e acF = e.acF();
        return (!com.baidu.swan.apps.storage.b.lS(str) || acF == null) ? str : com.baidu.swan.apps.storage.b.d(str, acF);
    }

    public void bbt() {
    }

    public void h(int i, int i2, String str) {
    }
}
