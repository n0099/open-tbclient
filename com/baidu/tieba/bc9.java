package com.baidu.tieba;

import android.view.View;
/* loaded from: classes4.dex */
public interface bc9 {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
