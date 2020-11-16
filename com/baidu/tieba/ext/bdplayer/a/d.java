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
    private f hrM;
    private a itJ;
    private String iua;
    private Uri mUri;

    public d(String str) {
        this.iua = str;
    }

    public static synchronized void fn(Context context) {
        synchronized (d.class) {
            if (!mHasInit && context != null) {
                mHasInit = true;
                BDPlayerConfig.setAppContext(context);
                BDPlayerConfig.initEnv(true);
                HashMap hashMap = new HashMap();
                hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
                BDPlayerConfig.initCyber(true, BDPlayerConfig.DEFAULT_INSTALL_TYPE, hashMap, new CyberPlayerManager.InstallListener() { // from class: com.baidu.tieba.ext.bdplayer.a.d.1
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
        fn(context);
        if (this.itJ == null) {
            this.itJ = new a(context, this.iua);
            this.mUri = uri;
            if (h.isDebug()) {
                Log.d(TAG, "new mBVideoView ");
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.hrM = fVar;
        if (this.itJ != null) {
            this.itJ.setPlayerListener(new b() { // from class: com.baidu.tieba.ext.bdplayer.a.d.2
                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onStart() {
                    super.onStart();
                    if (d.this.hrM != null) {
                        d.this.hrM.onStart();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onPause() {
                    super.onPause();
                    if (d.this.hrM != null) {
                        d.this.hrM.onPause();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onEnd(int i) {
                    super.onEnd(i);
                    if (d.this.hrM != null) {
                        d.this.hrM.onEnd(i);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onInfo(int i, int i2) {
                    super.onInfo(i, i2);
                    if (d.this.hrM != null) {
                        d.this.hrM.a(d.this, i, i2);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onError(int i, int i2, String str) {
                    super.onError(i, i2, str);
                    if (d.this.hrM != null) {
                        d.this.hrM.b(d.this, i, i2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setDecodeMode(int i) {
        if (this.itJ != null) {
            this.itJ.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public View getPlayerView() {
        LayerContainer layerContainer = this.itJ != null ? this.itJ.getLayerContainer() : null;
        if (layerContainer != null) {
            layerContainer.setClickable(false);
        }
        return layerContainer;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void eM(int i) {
        if (getPlayerView() != null) {
            getPlayerView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void c(Uri uri) {
        this.mUri = uri;
        if (this.itJ != null) {
            this.itJ.setVideoUrl(this.mUri.toString());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (this.itJ != null) {
            this.itJ.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        Log.d(TAG, "start :");
        if (this.itJ != null) {
            this.itJ.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
        Log.d(TAG, "pause :");
        if (this.itJ != null) {
            this.itJ.pause();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        Log.d(TAG, "resume :");
        if (this.itJ != null) {
            this.itJ.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        Log.d(TAG, "stop :");
        if (this.itJ != null) {
            this.itJ.stop();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        boolean[] zArr = new boolean[1];
        if (this.itJ != null) {
            zArr[0] = this.itJ.isPlaying();
        }
        return zArr[0];
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.itJ != null) {
            this.itJ.stop();
            this.itJ.getPlayerCallbackManager().release();
            this.itJ.detachFromContainer();
            this.itJ.release();
            Log.d(TAG, "release mBDVideoPlayer ");
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
        if (this.itJ != null) {
            this.itJ.b(i, map);
        }
    }

    public a ctB() {
        return this.itJ;
    }
}
