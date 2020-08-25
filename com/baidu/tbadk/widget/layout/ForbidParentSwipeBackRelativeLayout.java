package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class ForbidParentSwipeBackRelativeLayout extends RelativeLayout {
    public ForbidParentSwipeBackRelativeLayout(Context context) {
        super(context);
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForbidParentSwipeBackRelativeLayout(Context context, AttributeSet attributeSet, int i) {
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
