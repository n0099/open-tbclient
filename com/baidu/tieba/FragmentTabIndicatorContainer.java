package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicatorContainer extends FrameLayout {
    private FragmentTabIndicator a;
    private HashMap<String, w> b;

    public void a(String str, w wVar) {
        if (wVar != null && wVar.c != null) {
            this.b.put(str, wVar);
            addView(wVar.c);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (Map.Entry<String, w> entry : this.b.entrySet()) {
            w value = entry.getValue();
            if (value.c != null && value.c.getVisibility() == 0) {
                int measuredWidth = (getMeasuredWidth() / 2) + value.a;
                int i5 = value.b;
                value.c.layout(measuredWidth, i5, value.c.getMeasuredWidth() + measuredWidth, value.c.getMeasuredHeight() + i5);
            }
        }
    }

    public FragmentTabIndicatorContainer(Context context) {
        super(context);
        this.b = new HashMap<>();
    }

    public FragmentTabIndicatorContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new HashMap<>();
    }

    public FragmentTabIndicatorContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new HashMap<>();
    }

    public void a(int i) {
        if (this.a == null) {
            this.a = (FragmentTabIndicator) getChildAt(0);
        }
        this.a.a(i);
    }
}
