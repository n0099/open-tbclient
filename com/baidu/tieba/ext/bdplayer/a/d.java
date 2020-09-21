package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.liveroom.e.f;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.liveroom.e.d {
    private static final String TAG = d.class.getSimpleName();
    private static boolean mHasInit = false;
    private f gLu;
    private a hLB;
    private String hLS;
    private Uri mUri;

    public d(String str) {
        this.hLS = str;
    }

    public static synchronized void ff(Context context) {
        synchronized (d.class) {
            if (!mHasInit && context != null) {
                mHasInit = true;
                BDPlayerConfig.setAppContext(context);
                BDPlayerConfig.initEnv(true);
                HashMap hashMap = new HashMap();
                hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
                BDPlayerConfig.initCyber(true, BDPlayerConfig.DEFAULT_INSTALL_TYPE | 32, hashMap, new CyberPlayerManager.InstallListener() { // from class: com.baidu.tieba.ext.bdplayer.a.d.1
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                    public void onInstallError(int i, int i2, String str) {
                        Log.i("BDPlayerConfig", "onInstallError:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                    public void onInstallSuccess(int i, String str) {
                        Log.i("BDPlayerConfig", "onInstallSuccess" + i);
                    }

                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                    public void onInstallProgress(int i, int i2) {
                        Log.i("BDPlayerConfig", "onInstallProgress");
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void d(Context context, Uri uri) {
        ff(context);
        if (this.hLB == null) {
            this.hLB = new a(context, this.hLS);
            this.mUri = uri;
            if (h.isDebug()) {
                Log.d(TAG, "new mBVideoView ");
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.gLu = fVar;
        if (this.hLB != null) {
            this.hLB.setPlayerListener(new b() { // from class: com.baidu.tieba.ext.bdplayer.a.d.2
                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onStart() {
                    super.onStart();
                    if (d.this.gLu != null) {
                        d.this.gLu.onStart();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onPause() {
                    super.onPause();
                    if (d.this.gLu != null) {
                        d.this.gLu.onPause();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onEnd(int i) {
                    super.onEnd(i);
                    if (d.this.gLu != null) {
                        d.this.gLu.onEnd(i);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onInfo(int i, int i2) {
                    super.onInfo(i, i2);
                    if (d.this.gLu != null) {
                        d.this.gLu.a(d.this, i, i2);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onError(int i, int i2, String str) {
                    super.onError(i, i2, str);
                    if (d.this.gLu != null) {
                        d.this.gLu.b(d.this, i, i2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setDecodeMode(int i) {
        if (this.hLB != null) {
            this.hLB.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public View getPlayerView() {
        LayerContainer layerContainer = this.hLB != null ? this.hLB.getLayerContainer() : null;
        if (layerContainer != null) {
            layerContainer.setClickable(false);
        }
        return layerContainer;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void eE(int i) {
        if (getPlayerView() != null) {
            getPlayerView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void c(Uri uri) {
        this.mUri = uri;
        if (this.hLB != null) {
            this.hLB.setVideoUrl(this.mUri.toString());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (this.hLB != null) {
            this.hLB.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        Log.d(TAG, "start :");
        if (this.hLB != null) {
            this.hLB.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
        Log.d(TAG, "pause :");
        if (this.hLB != null) {
            this.hLB.pause();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        Log.d(TAG, "resume :");
        if (this.hLB != null) {
            this.hLB.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        Log.d(TAG, "stop :");
        if (this.hLB != null) {
            this.hLB.stop();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        boolean[] zArr = new boolean[1];
        if (this.hLB != null) {
            zArr[0] = this.hLB.isPlaying();
        }
        return zArr[0];
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.hLB != null) {
            this.hLB.stop();
            this.hLB.getPlayerCallbackManager().release();
            this.hLB.detachFromContainer();
            this.hLB.release();
            Log.d(TAG, "release mBDVideoPlayer ");
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
        if (this.hLB != null) {
            this.hLB.b(i, map);
        }
    }

    public a ckS() {
        return this.hLB;
    }
}
