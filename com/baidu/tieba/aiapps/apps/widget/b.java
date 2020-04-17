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
    private static boolean eGQ = false;
    private AudioManager aRi;
    private String bAK;
    private a.InterfaceC0307a bVA;
    private String bYS;
    private MediaPlayer bzL;
    private ZeusPluginFactory.Invoker eGR;
    private Context mContext;
    private boolean ccZ = false;
    private boolean eGS = false;
    private final MediaPlayer.OnPreparedListener cJG = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bVA != null) {
                b.this.bVA.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener cJI = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.Ec();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bVA != null) {
                b.this.bVA.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener cJH = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.Ec();
            if (b.this.bVA != null) {
                if (z) {
                    b.this.bVA.onEnded();
                } else {
                    b.this.bVA.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener evX = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bVA.fi(i);
            if (i == 3) {
                b.this.bjA();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener eGT = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener cJJ = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener evW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bVA != null) {
                b.this.bVA.abx();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener aRk = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
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
        void iL(boolean z);
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        this.eGR = invoker;
        if (this.eGR != null) {
            this.mContext = com.baidu.swan.apps.w.a.abO();
            this.bYS = (String) this.eGR.get("id");
        }
        this.bAK = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.abO(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void iL(boolean z) {
                aVar.dC(z);
            }
        });
    }

    private synchronized MediaPlayer Pt() {
        if (this.bzL == null) {
            this.bzL = new MediaPlayer();
            this.bzL.setOnPreparedListener(this.cJG);
            this.bzL.setOnVideoSizeChangedListener(this.evW);
            this.bzL.setOnCompletionListener(this.cJH);
            this.bzL.setOnErrorListener(this.cJI);
            this.bzL.setOnInfoListener(this.evX);
            this.bzL.setOnBufferingUpdateListener(this.eGT);
            this.bzL.setOnSeekCompleteListener(this.cJJ);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bzL.hashCode() + " 已创建");
            }
        }
        return this.bzL;
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
        this.eGS = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String kE = kE(str);
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
            Pt().setDataSource(this.mContext, Uri.parse(kE), hashMap);
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
        Pt().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        Eb();
        Pt().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYS + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        Eb();
        Pt().start();
        iK(true);
        if (this.bVA != null) {
            this.bVA.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYS + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        Pt().pause();
        iK(false);
        if (this.bVA != null) {
            this.bVA.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        Pt().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYS + " release()");
        }
        Ec();
        Pt().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return Pt().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return Pt().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return Pt().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return Pt().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return Pt().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void dD(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void aby() {
        if (isPlaying()) {
            this.ccZ = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void abz() {
        if (!isPlaying() && this.ccZ) {
            this.ccZ = false;
            start();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setMuted(boolean z) {
        setVolume(z ? 0.0f : 1.0f);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void a(@NonNull a.InterfaceC0307a interfaceC0307a) {
        this.bVA = interfaceC0307a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean abA() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abm() {
        return this.bYS;
    }

    private void Eb() {
        if (this.aRi == null) {
            this.aRi = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aRi != null) {
            try {
                this.aRi.requestAudioFocus(this.aRk, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (Pt() != null) {
            Pt().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!eGQ && aVar != null) {
            aVar.iL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec() {
        if (this.aRi == null) {
            this.aRi = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aRi != null) {
            this.aRi.abandonAudioFocus(this.aRk);
        }
    }

    private void iK(final boolean z) {
        ai.o(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e akN = e.akN();
                if (akN != null && (activity = akN.getActivity()) != null && (window = activity.getWindow()) != null) {
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

    private static String kE(String str) {
        e akN = e.akN();
        return (!com.baidu.swan.apps.storage.b.ne(str) || akN == null) ? str : com.baidu.swan.apps.storage.b.d(str, akN);
    }

    public void bjA() {
    }

    public void h(int i, int i2, String str) {
    }
}
