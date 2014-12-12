package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s aPn;
    private final /* synthetic */ FrameLayout aPo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, FrameLayout frameLayout) {
        this.aPn = sVar;
        this.aPo = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.aPo;
        view2 = this.aPn.aPj;
        frameLayout.removeView(view2);
    }
}
