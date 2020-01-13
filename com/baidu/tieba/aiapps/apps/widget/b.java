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
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.r.e.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean ect = false;
    private MediaPlayer aWX;
    private String aXX;
    private a.InterfaceC0267a bsW;
    private AudioManager bsY;
    private String bwp;
    private ZeusPluginFactory.Invoker ecu;
    private Context mContext;
    private boolean bzX = false;
    private boolean ecv = false;
    private final MediaPlayer.OnPreparedListener cgt = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bsW != null) {
                b.this.bsW.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener cgv = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.Fm();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bsW != null) {
                b.this.bsW.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener cgu = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.Fm();
            if (b.this.bsW != null) {
                if (z) {
                    b.this.bsW.onEnded();
                } else {
                    b.this.bsW.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dRp = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bsW.eN(i);
            if (i == 3) {
                b.this.aZb();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener ecw = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener cgw = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dRo = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bsW != null) {
                b.this.bsW.Rp();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bjr = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1) {
                b.this.pause();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void hF(boolean z);
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        this.ecu = invoker;
        if (this.ecu != null) {
            this.mContext = com.baidu.swan.apps.w.a.RG();
            this.bwp = (String) this.ecu.get("id");
        }
        this.aXX = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.RG(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void hF(boolean z) {
                aVar.cy(z);
            }
        });
    }

    private synchronized MediaPlayer Fk() {
        if (this.aWX == null) {
            this.aWX = new MediaPlayer();
            this.aWX.setOnPreparedListener(this.cgt);
            this.aWX.setOnVideoSizeChangedListener(this.dRo);
            this.aWX.setOnCompletionListener(this.cgu);
            this.aWX.setOnErrorListener(this.cgv);
            this.aWX.setOnInfoListener(this.dRp);
            this.aWX.setOnBufferingUpdateListener(this.ecw);
            this.aWX.setOnSeekCompleteListener(this.cgw);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.aWX.hashCode() + " 已创建");
            }
        }
        return this.aWX;
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
        this.ecv = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String jd = jd(str);
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
            Fk().setDataSource(this.mContext, Uri.parse(jd), hashMap);
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
        Fk().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        Fl();
        Fk().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bwp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        Fl();
        Fk().start();
        hE(true);
        if (this.bsW != null) {
            this.bsW.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bwp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        Fk().pause();
        hE(false);
        if (this.bsW != null) {
            this.bsW.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        Fk().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bwp + " release()");
        }
        Fm();
        Fk().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return Fk().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return Fk().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return Fk().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return Fk().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return Fk().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void cz(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void Rq() {
        if (isPlaying()) {
            this.bzX = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void Rr() {
        if (!isPlaying() && this.bzX) {
            this.bzX = false;
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
    public void a(@NonNull a.InterfaceC0267a interfaceC0267a) {
        this.bsW = interfaceC0267a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean Rs() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Re() {
        return this.bwp;
    }

    private void Fl() {
        if (this.bsY == null) {
            this.bsY = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bsY != null) {
            try {
                this.bsY.requestAudioFocus(this.bjr, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (Fk() != null) {
            Fk().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!ect && aVar != null) {
            aVar.hF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (this.bsY == null) {
            this.bsY = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bsY != null) {
            this.bsY.abandonAudioFocus(this.bjr);
        }
    }

    private void hE(final boolean z) {
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e aap = e.aap();
                if (aap != null && (activity = aap.getActivity()) != null && (window = activity.getWindow()) != null) {
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

    private static String jd(String str) {
        e aap = e.aap();
        return (!com.baidu.swan.apps.storage.b.lD(str) || aap == null) ? str : com.baidu.swan.apps.storage.b.d(str, aap);
    }

    public void aZb() {
    }

    public void h(int i, int i2, String str) {
    }
}
