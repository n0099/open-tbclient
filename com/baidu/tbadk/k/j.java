package com.baidu.tbadk.k;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class j implements d {
    @Override // com.baidu.tbadk.k.d
    public void attachView(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        view2.setLayoutParams(layoutParams);
    }
}
