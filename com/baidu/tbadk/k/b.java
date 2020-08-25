package com.baidu.tbadk.k;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b implements d {
    @Override // com.baidu.tbadk.k.d
    public void attachView(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
    }
}
