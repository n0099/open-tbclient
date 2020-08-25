package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.baidu.live.liveroom.e.f;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.layer.LayerContainer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.baidu.live.liveroom.e.d {
    private static final String TAG = d.class.getSimpleName();
    private static boolean mHasInit = false;
    private f gHP;
    private String hEK;
    private a hEt;
    private Uri mUri;

    public d(String str) {
        this.hEK = str;
    }

    public static synchronized void eZ(Context context) {
        synchronized (d.class) {
            if (!mHasInit && context != null) {
                mHasInit = true;
                BDPlayerConfig.setAppContext(context);
                BDPlayerConfig.initEnv(true);
                BDPlayerConfig.initCyber();
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void d(Context context, Uri uri) {
        eZ(context);
        if (this.hEt == null) {
            this.hEt = new a(context, this.hEK);
            this.mUri = uri;
            Log.d(TAG, "new mBVideoView ");
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.gHP = fVar;
        if (this.hEt != null) {
            this.hEt.setPlayerListener(new b() { // from class: com.baidu.tieba.ext.bdplayer.a.d.1
                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onStart() {
                    super.onStart();
                    if (d.this.gHP != null) {
                        d.this.gHP.onStart();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onPause() {
                    super.onPause();
                    if (d.this.gHP != null) {
                        d.this.gHP.onPause();
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onEnd(int i) {
                    super.onEnd(i);
                    if (d.this.gHP != null) {
                        d.this.gHP.onEnd(i);
                    }
                }

                @Override // com.baidu.tieba.ext.bdplayer.a.b, com.baidu.searchbox.player.callback.IVideoPlayerCallback
                public void onInfo(int i, int i2) {
                    super.onInfo(i, i2);
                    if (d.this.gHP != null) {
                        d.this.gHP.a(d.this, i, i2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setDecodeMode(int i) {
        if (this.hEt != null) {
            this.hEt.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public View getPlayerView() {
        LayerContainer layerContainer = this.hEt != null ? this.hEt.getLayerContainer() : null;
        if (layerContainer != null) {
            layerContainer.setClickable(false);
        }
        return layerContainer;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void eA(int i) {
        if (getPlayerView() != null) {
            getPlayerView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void c(Uri uri) {
        this.mUri = uri;
        if (this.hEt != null) {
            this.hEt.setVideoUrl(this.mUri.toString());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (this.hEt != null) {
            this.hEt.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        Log.d(TAG, "start :");
        if (this.hEt != null) {
            this.hEt.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
        Log.d(TAG, "pause :");
        if (this.hEt != null) {
            this.hEt.pause();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        Log.d(TAG, "resume :");
        if (this.hEt != null) {
            this.hEt.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        Log.d(TAG, "stop :");
        if (this.hEt != null) {
            this.hEt.stop();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        boolean[] zArr = new boolean[1];
        if (this.hEt != null) {
            zArr[0] = this.hEt.isPlaying();
        }
        return zArr[0];
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.hEt != null) {
            this.hEt.stop();
            this.hEt.getPlayerCallbackManager().release();
            this.hEt.detachFromContainer();
            this.hEt.release();
            Log.d(TAG, "release mBDVideoPlayer ");
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
        if (this.hEt != null) {
            this.hEt.b(i, map);
        }
    }

    public a chE() {
        return this.hEt;
    }
}
