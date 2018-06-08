package com.baidu.tieba.frs.worldcup.videotopic.insertcard;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class ForbidParentSwipeBackLinearLayout extends LinearLayout {
    private int mActivePointerId;
    private float mInitialMotionX;
    private float mInitialMotionY;

    public ForbidParentSwipeBackLinearLayout(Context context) {
        super(context);
        this.mActivePointerId = -1;
    }

    public ForbidParentSwipeBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
    }

    public ForbidParentSwipeBackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
    }

    @Override // android.view.View
    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                if (this.mActivePointerId != -1) {
                    this.mInitialMotionX = motionEvent.getX(actionIndex);
                    this.mInitialMotionY = motionEvent.getY(actionIndex);
                    break;
                }
                break;
            case 2:
                determinIntercept(motionEvent);
                break;
        }
        return super.onFilterTouchEventForSecurity(motionEvent);
    }

    private void determinIntercept(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                if (Math.abs(motionEvent.getX(pointerIndex) - this.mInitialMotionX) > Math.abs(motionEvent.getY(pointerIndex) - this.mInitialMotionY)) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                } else if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }
}
