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
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.apps.r.e.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean eck = false;
    private MediaPlayer aWf;
    private String aXf;
    private a.InterfaceC0265a bsi;
    private AudioManager bsk;
    private String bvC;
    private ZeusPluginFactory.Invoker ecl;
    private Context mContext;
    private boolean bzk = false;
    private boolean ecm = false;
    private final MediaPlayer.OnPreparedListener cgg = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bsi != null) {
                b.this.bsi.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener cgi = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.EQ();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bsi != null) {
                b.this.bsi.onError(i3);
            }
            b.this.g(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener cgh = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.EQ();
            if (b.this.bsi != null) {
                if (z) {
                    b.this.bsi.onEnded();
                } else {
                    b.this.bsi.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dRg = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bsi.eM(i);
            if (i == 3) {
                b.this.aYH();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener ecn = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener cgj = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dRf = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bsi != null) {
                b.this.bsi.QT();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener biC = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1) {
                b.this.pause();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface a {
        void hA(boolean z);
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        this.ecl = invoker;
        if (this.ecl != null) {
            this.mContext = com.baidu.swan.apps.w.a.Rk();
            this.bvC = (String) this.ecl.get("id");
        }
        this.aXf = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.Rk(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void hA(boolean z) {
                aVar.ct(z);
            }
        });
    }

    private synchronized MediaPlayer EO() {
        if (this.aWf == null) {
            this.aWf = new MediaPlayer();
            this.aWf.setOnPreparedListener(this.cgg);
            this.aWf.setOnVideoSizeChangedListener(this.dRf);
            this.aWf.setOnCompletionListener(this.cgh);
            this.aWf.setOnErrorListener(this.cgi);
            this.aWf.setOnInfoListener(this.dRg);
            this.aWf.setOnBufferingUpdateListener(this.ecn);
            this.aWf.setOnSeekCompleteListener(this.cgj);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.aWf.hashCode() + " 已创建");
            }
        }
        return this.aWf;
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
        this.ecm = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String ja = ja(str);
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
            EO().setDataSource(this.mContext, Uri.parse(ja), hashMap);
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
        EO().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        EP();
        EO().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bvC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        EP();
        EO().start();
        hz(true);
        if (this.bsi != null) {
            this.bsi.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bvC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        EO().pause();
        hz(false);
        if (this.bsi != null) {
            this.bsi.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        EO().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bvC + " release()");
        }
        EQ();
        EO().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return EO().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return EO().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return EO().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return EO().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return EO().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void cu(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void QU() {
        if (isPlaying()) {
            this.bzk = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void QV() {
        if (!isPlaying() && this.bzk) {
            this.bzk = false;
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
    public void a(@NonNull a.InterfaceC0265a interfaceC0265a) {
        this.bsi = interfaceC0265a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean QW() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String QI() {
        return this.bvC;
    }

    private void EP() {
        if (this.bsk == null) {
            this.bsk = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bsk != null) {
            try {
                this.bsk.requestAudioFocus(this.biC, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (EO() != null) {
            EO().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!eck && aVar != null) {
            aVar.hA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        if (this.bsk == null) {
            this.bsk = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bsk != null) {
            this.bsk.abandonAudioFocus(this.biC);
        }
    }

    private void hz(final boolean z) {
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e ZS = e.ZS();
                if (ZS != null && (activity = ZS.getActivity()) != null && (window = activity.getWindow()) != null) {
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

    private static String ja(String str) {
        e ZS = e.ZS();
        return (!com.baidu.swan.apps.storage.b.lA(str) || ZS == null) ? str : com.baidu.swan.apps.storage.b.d(str, ZS);
    }

    public void aYH() {
    }

    public void g(int i, int i2, String str) {
    }
}
