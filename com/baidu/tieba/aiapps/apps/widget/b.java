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
    private static boolean eGV = false;
    private AudioManager aRn;
    private String bAP;
    private a.InterfaceC0328a bVG;
    private String bYY;
    private MediaPlayer bzQ;
    private ZeusPluginFactory.Invoker eGW;
    private Context mContext;
    private boolean cdf = false;
    private boolean eGX = false;
    private final MediaPlayer.OnPreparedListener cJM = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bVG != null) {
                b.this.bVG.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener cJO = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.Eb();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bVG != null) {
                b.this.bVG.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener cJN = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.Eb();
            if (b.this.bVG != null) {
                if (z) {
                    b.this.bVG.onEnded();
                } else {
                    b.this.bVG.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener ewc = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bVG.fi(i);
            if (i == 3) {
                b.this.bjy();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener eGY = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener cJP = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener ewb = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bVG != null) {
                b.this.bVG.abw();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener aRp = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
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
        this.eGW = invoker;
        if (this.eGW != null) {
            this.mContext = com.baidu.swan.apps.w.a.abN();
            this.bYY = (String) this.eGW.get("id");
        }
        this.bAP = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.abN(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void iL(boolean z) {
                aVar.dC(z);
            }
        });
    }

    private synchronized MediaPlayer Ps() {
        if (this.bzQ == null) {
            this.bzQ = new MediaPlayer();
            this.bzQ.setOnPreparedListener(this.cJM);
            this.bzQ.setOnVideoSizeChangedListener(this.ewb);
            this.bzQ.setOnCompletionListener(this.cJN);
            this.bzQ.setOnErrorListener(this.cJO);
            this.bzQ.setOnInfoListener(this.ewc);
            this.bzQ.setOnBufferingUpdateListener(this.eGY);
            this.bzQ.setOnSeekCompleteListener(this.cJP);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bzQ.hashCode() + " 已创建");
            }
        }
        return this.bzQ;
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
        this.eGX = true;
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
            Ps().setDataSource(this.mContext, Uri.parse(kE), hashMap);
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
        Ps().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        Ea();
        Ps().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYY + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        Ea();
        Ps().start();
        iK(true);
        if (this.bVG != null) {
            this.bVG.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYY + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        Ps().pause();
        iK(false);
        if (this.bVG != null) {
            this.bVG.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        Ps().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bYY + " release()");
        }
        Eb();
        Ps().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return Ps().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return Ps().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return Ps().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return Ps().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return Ps().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void dD(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void abx() {
        if (isPlaying()) {
            this.cdf = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void aby() {
        if (!isPlaying() && this.cdf) {
            this.cdf = false;
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
    public void a(@NonNull a.InterfaceC0328a interfaceC0328a) {
        this.bVG = interfaceC0328a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean abz() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String abl() {
        return this.bYY;
    }

    private void Ea() {
        if (this.aRn == null) {
            this.aRn = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aRn != null) {
            try {
                this.aRn.requestAudioFocus(this.aRp, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (Ps() != null) {
            Ps().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!eGV && aVar != null) {
            aVar.iL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        if (this.aRn == null) {
            this.aRn = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aRn != null) {
            this.aRn.abandonAudioFocus(this.aRp);
        }
    }

    private void iK(final boolean z) {
        ai.o(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e akM = e.akM();
                if (akM != null && (activity = akM.getActivity()) != null && (window = activity.getWindow()) != null) {
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
        e akM = e.akM();
        return (!com.baidu.swan.apps.storage.b.ne(str) || akM == null) ? str : com.baidu.swan.apps.storage.b.d(str, akM);
    }

    public void bjy() {
    }

    public void h(int i, int i2, String str) {
    }
}
