package com.baidu.tieba;

import android.view.View;
/* loaded from: classes6.dex */
public interface g1a {
    void autoPlay(int i);

    boolean canPlay();

    long getCurrentPosition();

    int getPlayStatus();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}
