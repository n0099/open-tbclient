package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1009a;
    private z b;

    public FragmentTabWidget(Context context) {
        super(context);
        this.f1009a = -1;
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1009a = -1;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < getChildCount() && this.f1009a != i) {
            if (this.f1009a != -1) {
                getChildAt(this.f1009a).setSelected(false);
            }
            this.f1009a = i;
            getChildAt(this.f1009a).setSelected(true);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        a(view);
        super.addView(view);
        view.setOnClickListener(new aa(this, getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
        super.addView(view, i);
        view.setOnClickListener(new aa(this, getChildCount() - 1));
    }

    private void a(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTabSelectionListener(z zVar) {
        this.b = zVar;
    }

    public void a() {
        removeAllViews();
        this.f1009a = -1;
    }
}
