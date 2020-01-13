package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class AlaActiveRootView extends FrameLayout implements com.baidu.live.g.b {
    public AlaActiveRootView(Context context) {
        super(context);
        init();
    }

    public View getLastChild() {
        if (getChildCount() < 1) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public void onStart() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    ((c) childAt).onStart();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onStop() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    ((c) childAt).onStop();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    ((c) childAt).release();
                }
                i = i2 + 1;
            } else {
                removeAllViews();
                return;
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setId(a.g.ala_liveroom_active_view);
        setMinimumWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds104));
    }

    public void setViewTouchable(boolean z) {
    }

    @Override // com.baidu.live.g.b
    public View getOverlayView() {
        return this;
    }
}
