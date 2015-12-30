package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class BlessRelativeLayout extends RelativeLayout {
    private float y;

    public BlessRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BlessRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlessRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.y = motionEvent.getY();
                return super.dispatchTouchEvent(motionEvent);
            case 1:
                if (Math.abs(this.y - motionEvent.getY()) < 10.0f) {
                    View childAt = getChildAt(3);
                    if (new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        getChildAt(2).setEnabled(false);
                        childAt.performClick();
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
