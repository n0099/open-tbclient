package com.baidu.tieba.ala.liveroom.activeview;

import com.baidu.live.data.ab;
import com.baidu.live.data.t;
/* loaded from: classes10.dex */
public interface c {
    void onStart();

    void onStop();

    void release();

    void setCallback(a aVar);

    void setData(boolean z, ab abVar, t tVar);
}
