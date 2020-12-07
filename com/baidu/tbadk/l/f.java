package com.baidu.tbadk.l;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f implements d {
    @Override // com.baidu.tbadk.l.d
    public void attachView(View view, View view2, boolean z) {
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
