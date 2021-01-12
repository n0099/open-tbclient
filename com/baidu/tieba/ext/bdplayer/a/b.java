package com.baidu.tieba.ext.bdplayer.a;

import android.util.Log;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes10.dex */
public class b implements IVideoPlayerCallback {
    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onStart() {
        if (isDebug()) {
            d(MissionEvent.MESSAGE_START);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onPause() {
        if (isDebug()) {
            d(MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onResume() {
        if (isDebug()) {
            d(MissionEvent.MESSAGE_RESUME);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onEnd(int i) {
        if (isDebug()) {
            d("onEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onBufferStart() {
        if (isDebug()) {
            d("onBufferStart");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onBufferEnd() {
        if (isDebug()) {
            d("onBufferEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onNetworkSpeedUpdate(int i) {
        if (isDebug()) {
            d("onNetworkSpeedUpdate");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onSeekEnd() {
        if (isDebug()) {
            d("onSeekEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onError(int i, int i2, String str) {
        if (isDebug()) {
            d("onError");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onInfo(int i, int i2) {
        if (isDebug()) {
            d("onInfo " + i + ", " + i2);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onPrepared() {
        if (isDebug()) {
            d("onPrepared");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onVideoSizeChanged(int i, int i2) {
        if (isDebug()) {
            d("onVideoSizeChanged");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void goBackOrForeground(boolean z) {
        if (isDebug()) {
            d("goBackOrForeground " + z);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onUpdateProgress(int i, int i2, int i3) {
        if (isDebug()) {
            d("onUpdateProgress " + i + ", " + i2 + ", " + i3);
        }
    }

    private static void d(String str) {
        Log.d("BDPlayerCallback", str);
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
