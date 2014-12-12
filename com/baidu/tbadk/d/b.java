package com.baidu.tbadk.d;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class b implements c {
    @Override // com.baidu.tbadk.d.c
    public void a(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
    }
}
