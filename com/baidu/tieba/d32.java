package com.baidu.tieba;

import android.view.KeyEvent;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public interface d32 {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onScrollChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);
}
