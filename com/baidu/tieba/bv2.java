package com.baidu.tieba;

import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
/* loaded from: classes3.dex */
public interface bv2 {
    void onGetCurrentSong(String str);

    void onGetDownloadProgress(int i);

    void onGetDuration(int i);

    void onGetPosition(int i, int i2);

    void onInvokeFailed();

    void onStateChanged(BgMusicPlayState bgMusicPlayState);
}
