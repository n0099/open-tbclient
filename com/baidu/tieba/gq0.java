package com.baidu.tieba;

import android.view.MotionEvent;
/* loaded from: classes4.dex */
public interface gq0 {
    void onBeforeSwitchToFull();

    void onBeforeSwitchToHalf();

    void onGestureActionEnd();

    void onGestureActionStart();

    boolean onGestureDoubleClick(MotionEvent motionEvent);

    void onPanelVisibilityChanged(boolean z);

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
