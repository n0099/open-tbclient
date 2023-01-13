package com.baidu.tieba;

import android.view.View;
/* loaded from: classes3.dex */
public interface ak8 {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
