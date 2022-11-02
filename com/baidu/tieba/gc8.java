package com.baidu.tieba;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes4.dex */
public interface gc8 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    hc8 getMediaProgressObserver();

    int getPcdnState();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(zc8 zc8Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(uc8 uc8Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
