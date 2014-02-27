package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int a;
    private r b;

    public FragmentTabWidget(Context context) {
        super(context);
        this.a = -1;
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < getChildCount() && this.a != i) {
            if (this.a != -1) {
                getChildAt(this.a).setSelected(false);
            }
            this.a = i;
            getChildAt(this.a).setSelected(true);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        a(view);
        super.addView(view);
        view.setOnClickListener(new s(this, getChildCount() - 1, (byte) 0));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
        super.addView(view, i);
        view.setOnClickListener(new s(this, getChildCount() - 1, (byte) 0));
    }

    private static void a(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTabSelectionListener(r rVar) {
        this.b = rVar;
    }

    public final void a() {
        removeAllViews();
        this.a = -1;
    }
}
