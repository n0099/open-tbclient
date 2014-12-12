package com.baidu.tbadk.d;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e implements c {
    @Override // com.baidu.tbadk.d.c
    public void a(View view, View view2, boolean z) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (z) {
            linearLayout.addView(view2, 0);
        } else {
            linearLayout.addView(view2);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.gravity = 1;
        view2.setLayoutParams(layoutParams);
    }
}
