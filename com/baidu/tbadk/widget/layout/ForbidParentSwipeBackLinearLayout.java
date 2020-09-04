package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class ForbidParentSwipeBackLinearLayout extends LinearLayout {
    public ForbidParentSwipeBackLinearLayout(Context context) {
        super(context);
    }

    public ForbidParentSwipeBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForbidParentSwipeBackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            if (getContext() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
            } else if (getContext() instanceof BaseActivity) {
                ((BaseActivity) getContext()).disableSwipeJustOnce();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
