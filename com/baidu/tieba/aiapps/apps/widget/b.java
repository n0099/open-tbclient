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
    private static boolean eha = false;
    private AudioManager axD;
    private String bAL;
    private MediaPlayer bbx;
    private String bcw;
    private a.InterfaceC0277a bxu;
    private ZeusPluginFactory.Invoker ehb;
    private Context mContext;
    private boolean bEq = false;
    private boolean ehc = false;
    private final MediaPlayer.OnPreparedListener ckK = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.4
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onPrepared()");
            }
            if (b.this.bxu != null) {
                b.this.bxu.onPrepared();
            }
        }
    };
    private final MediaPlayer.OnErrorListener ckM = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onError(" + i + ", " + i2 + ")");
            }
            b.this.zh();
            int i3 = i == -10000 ? 0 : i;
            if (b.this.bxu != null) {
                b.this.bxu.onError(i3);
            }
            b.this.h(i, i2, "");
            return false;
        }
    };
    private final MediaPlayer.OnCompletionListener ckL = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z = b.this.getDuration() != 0 && b.this.getCurrentPosition() >= b.this.getDuration();
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            b.this.zh();
            if (b.this.bxu != null) {
                if (z) {
                    b.this.bxu.onEnded();
                } else {
                    b.this.bxu.onPaused();
                }
            }
        }
    };
    private final MediaPlayer.OnInfoListener dVY = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.7
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onInfo(" + i + ", " + i2 + ")");
            }
            b.this.bxu.fd(i);
            if (i == 3) {
                b.this.bbx();
                return false;
            }
            return false;
        }
    };
    private final MediaPlayer.OnBufferingUpdateListener ehd = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.8
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final MediaPlayer.OnSeekCompleteListener ckN = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.9
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final MediaPlayer.OnVideoSizeChangedListener dVX = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.10
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + b.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ")");
            }
            if (b.this.bxu != null) {
                b.this.bxu.TI();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener axF = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.tieba.aiapps.apps.widget.b.2
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
        void hN(boolean z);
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        this.ehb = invoker;
        if (this.ehb != null) {
            this.mContext = com.baidu.swan.apps.w.a.TZ();
            this.bAL = (String) this.ehb.get("id");
        }
        this.bcw = str;
    }

    @Override // com.baidu.swan.apps.r.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.w.a.TZ(), new a() { // from class: com.baidu.tieba.aiapps.apps.widget.b.1
            @Override // com.baidu.tieba.aiapps.apps.widget.b.a
            public void hN(boolean z) {
                aVar.cG(z);
            }
        });
    }

    private synchronized MediaPlayer HG() {
        if (this.bbx == null) {
            this.bbx = new MediaPlayer();
            this.bbx.setOnPreparedListener(this.ckK);
            this.bbx.setOnVideoSizeChangedListener(this.dVX);
            this.bbx.setOnCompletionListener(this.ckL);
            this.bbx.setOnErrorListener(this.ckM);
            this.bbx.setOnInfoListener(this.dVY);
            this.bbx.setOnBufferingUpdateListener(this.ehd);
            this.bbx.setOnSeekCompleteListener(this.ckN);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "新的CyberPlayer实例 " + this.bbx.hashCode() + " 已创建");
            }
        }
        return this.bbx;
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
        this.ehc = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String jr = jr(str);
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
            HG().setDataSource(this.mContext, Uri.parse(jr), hashMap);
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
        HG().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean prepareAsync() {
        zg();
        HG().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        zg();
        HG().start();
        hM(true);
        if (this.bxu != null) {
            this.bxu.onPlayed();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        HG().pause();
        hM(false);
        if (this.bxu != null) {
            this.bxu.onPaused();
        }
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void seekTo(int i) {
        HG().seekTo(i);
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.bAL + " release()");
        }
        zh();
        HG().release();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getDuration() {
        return HG().getDuration();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getCurrentPosition() {
        return HG().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean isPlaying() {
        return HG().isPlaying();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoWidth() {
        return HG().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public int getVideoHeight() {
        return HG().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void cH(boolean z) {
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TJ() {
        if (isPlaying()) {
            this.bEq = true;
        }
        pause();
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void TK() {
        if (!isPlaying() && this.bEq) {
            this.bEq = false;
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
        this.bxu = interfaceC0277a;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public boolean TL() {
        return false;
    }

    @Override // com.baidu.swan.apps.r.e.b.a
    public void setSpeed(float f) {
    }

    @Override // com.baidu.swan.apps.r.d
    @Nullable
    public String Tx() {
        return this.bAL;
    }

    private void zg() {
        if (this.axD == null) {
            this.axD = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.axD != null) {
            try {
                this.axD.requestAudioFocus(this.axF, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setVolume(float f) {
        if (HG() != null) {
            HG().setVolume(f, f);
        }
    }

    private static void a(@NonNull Context context, @Nullable a aVar) {
        if (!eha && aVar != null) {
            aVar.hN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (this.axD == null) {
            this.axD = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.axD != null) {
            this.axD.abandonAudioFocus(this.axF);
        }
    }

    private void hM(final boolean z) {
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.widget.b.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Window window;
                e acI = e.acI();
                if (acI != null && (activity = acI.getActivity()) != null && (window = activity.getWindow()) != null) {
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

    private static String jr(String str) {
        e acI = e.acI();
        return (!com.baidu.swan.apps.storage.b.lR(str) || acI == null) ? str : com.baidu.swan.apps.storage.b.d(str, acI);
    }

    public void bbx() {
    }

    public void h(int i, int i2, String str) {
    }
}
