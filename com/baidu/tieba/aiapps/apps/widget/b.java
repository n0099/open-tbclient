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
    private static boolean egx = false;
    private String bAz;
    private MediaPlayer bbj;
    private String bci;
    private a.InterfaceC0277a bxh;
    private AudioManager bxj;
    private ZeusPluginFactory.Invoker egy;
    private Context mContext;
    private boolean bEe = false;
    private boolean egz = false;
    private final MediaPlayer.OnPreparedListener cky = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bxh != null) {
                b.this.bxh.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener ckA = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.HD();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bxh != null) {
                b.this.bxh.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener ckz = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.HD();
            if (b.this.bxh != null) {
                if (z) {
                    b.this.bxh.onEnded();
                } else {
                    b.this.bxh.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dVv = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bxh.fd(i);
            if (i == 3) {
                b.this.bbs();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener egA = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener ckB = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dVu = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bxh != null) {
                b.this.bxh.TF();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bnC = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
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
        this.egy = invoker;
        if (this.egy != null) {
            this.mContext = com.baidu.swan.apps.w.a.TW();
            this.bAz = (String) this.egy.get("id");
        }
        this.bci = str;
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
        if (this.bbj == null) {
            this.bbj = new MediaPlayer();
            this.bbj.setOnPreparedListener(this.cky);
            this.bbj.setOnVideoSizeChangedListener(this.dVu);
            this.bbj.setOnCompletionListener(this.ckz);
            this.bbj.setOnErrorListener(this.ckA);
            this.bbj.setOnInfoListener(this.dVv);
            this.bbj.setOnBufferingUpdateListener(this.egA);
            this.bbj.setOnSeekCompleteListener(this.ckB);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bbj.hashCode() + " 已创建");
            }
        }
        return this.bbj;
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
        this.egz = true;
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
            Log.d("SwanInlineCyberWidget", this.bAz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        HC();
        HB().start();
        hL(true);
        if (this.bxh != null) {
            this.bxh.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        HB().pause();
        hL(false);
        if (this.bxh != null) {
            this.bxh.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        HB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAz + " release()");
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
            this.bEe = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TH() {
        if (!isPlaying() && this.bEe) {
            this.bEe = false;
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
        this.bxh = interfaceC0277a;
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
        return this.bAz;
    }

    private void HC() {
        if (this.bxj == null) {
            this.bxj = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxj != null) {
            try {
                this.bxj.requestAudioFocus(this.bnC, 3, 1);
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
        if (!egx && aVar != null) {
            aVar.hM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (this.bxj == null) {
            this.bxj = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxj != null) {
            this.bxj.abandonAudioFocus(this.bnC);
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

    public void bbs() {
    }

    public void h(int i, int i2, String str) {
    }
}
