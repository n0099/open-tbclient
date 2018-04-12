package com.baidu.tbadk.j;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class h implements c {
    @Override // com.baidu.tbadk.j.c
    public void a(View view2, View view3, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) view2;
        if (z) {
            relativeLayout.addView(view3, 0);
        } else {
            relativeLayout.addView(view3);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view3.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(14);
        view3.setLayoutParams(layoutParams);
    }
}
