package com.baidu.tieba.ext.bdplayer.a;

import android.util.Log;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public class b implements IVideoPlayerCallback {
    private static final Boolean hEM = true;

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onStart() {
        if (hEM.booleanValue()) {
            d(MissionEvent.MESSAGE_START);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onPause() {
        if (hEM.booleanValue()) {
            d(MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onResume() {
        if (hEM.booleanValue()) {
            d(MissionEvent.MESSAGE_RESUME);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onEnd(int i) {
        if (hEM.booleanValue()) {
            d("onEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onBufferStart() {
        if (hEM.booleanValue()) {
            d("onBufferStart");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onBufferEnd() {
        if (hEM.booleanValue()) {
            d("onBufferEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onNetworkSpeedUpdate(int i) {
        if (hEM.booleanValue()) {
            d("onNetworkSpeedUpdate");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onSeekEnd() {
        if (hEM.booleanValue()) {
            d("onSeekEnd");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onError(int i, int i2, String str) {
        if (hEM.booleanValue()) {
            d("onError");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onInfo(int i, int i2) {
        if (hEM.booleanValue()) {
            d("onInfo " + i + ", " + i2);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onPrepared() {
        if (hEM.booleanValue()) {
            d("onPrepared");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onVideoSizeChanged(int i, int i2) {
        if (hEM.booleanValue()) {
            d("onVideoSizeChanged");
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void goBackOrForeground(boolean z) {
        if (hEM.booleanValue()) {
            d("goBackOrForeground " + z);
        }
    }

    @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
    public void onUpdateProgress(int i, int i2, int i3) {
        if (hEM.booleanValue()) {
            d("onUpdateProgress " + i + ", " + i2 + ", " + i3);
        }
    }

    private static void d(String str) {
        Log.d("BDPlayerCallback", str);
    }
}
