package com.baidu.tieba;

import android.view.MotionEvent;
/* loaded from: classes5.dex */
public interface dv0 {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    boolean onGestureDoubleClick(MotionEvent motionEvent);

    void onPanelVisibilityChanged(boolean z);

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
