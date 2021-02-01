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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.liveroom.e.d {
    private static final String TAG = d.class.getSimpleName();
    private static boolean mHasInit = false;
    private f hNl;
    private a iRQ;
    private String iSg;
    private Uri mUri;

    public d(String str) {
        this.iSg = str;
    }

    public static synchronized void gl(Context context) {
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
                        Log.i("BDPlayerConfig", "onInstallError:" + i + "," + i2 + "," + str);
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
        gl(context);
        if (this.iRQ == null) {
            this.iRQ = new a(context, this.iSg);
            this.mUri = uri;
            if (h.isDebug()) {
                Log.d(TAG, "new mBVideoView ");
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.hNl = fVar;
        if (this.iRQ != null) {
            this.iRQ.setPlayerListener(new b() { // from class: com.baidu.tieba.ext.bdplayer.a.d.2
                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onStart() {
                    super.onStart();
                    if (d.this.hNl != null) {
                        d.this.hNl.onStart();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onPause() {
                    super.onPause();
                    if (d.this.hNl != null) {
                        d.this.hNl.onPause();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onEnd(int i) {
                    super.onEnd(i);
                    if (d.this.hNl != null) {
                        d.this.hNl.onEnd(i);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onInfo(int i, int i2) {
                    super.onInfo(i, i2);
                    if (d.this.hNl != null) {
                        d.this.hNl.a(d.this, i, i2);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onError(int i, int i2, String str) {
                    super.onError(i, i2, str);
                    if (d.this.hNl != null) {
                        d.this.hNl.b(d.this, i, i2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setDecodeMode(int i) {
        if (this.iRQ != null) {
            this.iRQ.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public View MS() {
        LayerContainer layerContainer = this.iRQ != null ? this.iRQ.getLayerContainer() : null;
        if (layerContainer != null) {
            layerContainer.setClickable(false);
        }
        return layerContainer;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void dH(int i) {
        if (MS() != null) {
            MS().setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void e(Uri uri) {
        this.mUri = uri;
        if (this.iRQ != null) {
            this.iRQ.setVideoUrl(this.mUri.toString());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (this.iRQ != null) {
            this.iRQ.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        Log.d(TAG, "start :");
        if (this.iRQ != null) {
            this.iRQ.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
        Log.d(TAG, "pause :");
        if (this.iRQ != null) {
            this.iRQ.pause();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        Log.d(TAG, "resume :");
        if (this.iRQ != null) {
            this.iRQ.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        Log.d(TAG, "stop :");
        if (this.iRQ != null) {
            this.iRQ.stop();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        boolean[] zArr = new boolean[1];
        if (this.iRQ != null) {
            zArr[0] = this.iRQ.isPlaying();
        }
        return zArr[0];
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.iRQ != null) {
            this.iRQ.stop();
            this.iRQ.getPlayerCallbackManager().release();
            this.iRQ.detachFromContainer();
            this.iRQ.release();
            Log.d(TAG, "release mBDVideoPlayer ");
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
        if (this.iRQ != null) {
            this.iRQ.b(i, map);
        }
    }

    public a cye() {
        return this.iRQ;
    }
}
