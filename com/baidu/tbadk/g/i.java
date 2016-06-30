package com.baidu.tbadk.g;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class i implements c {
    @Override // com.baidu.tbadk.g.c
    public void a(View view, View view2, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (z) {
            relativeLayout.addView(view2, 0);
        } else {
            relativeLayout.addView(view2);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(14);
        view2.setLayoutParams(layoutParams);
    }
}
