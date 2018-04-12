package com.baidu.tbadk.j;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e implements c {
    @Override // com.baidu.tbadk.j.c
    public void a(View view2, View view3, boolean z) {
        LinearLayout linearLayout = (LinearLayout) view2;
        if (z) {
            linearLayout.addView(view3, 0);
        } else {
            linearLayout.addView(view3);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view3.getLayoutParams();
        layoutParams.gravity = 1;
        view3.setLayoutParams(layoutParams);
    }
}
