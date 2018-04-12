package com.baidu.tbadk.j;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class b implements c {
    @Override // com.baidu.tbadk.j.c
    public void a(View view2, View view3, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view2;
        if (z) {
            frameLayout.addView(view3, 0);
        } else {
            frameLayout.addView(view3);
        }
    }
}
