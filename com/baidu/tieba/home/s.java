package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r aMP;
    private final /* synthetic */ FrameLayout aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, FrameLayout frameLayout) {
        this.aMP = rVar;
        this.aMQ = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.aMQ;
        view2 = this.aMP.aML;
        frameLayout.removeView(view2);
    }
}
