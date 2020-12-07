package com.baidu.tbadk.l;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class b implements d {
    @Override // com.baidu.tbadk.l.d
    public void attachView(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
    }
}
