package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r aNd;
    private final /* synthetic */ FrameLayout aNe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, FrameLayout frameLayout) {
        this.aNd = rVar;
        this.aNe = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.aNe;
        view2 = this.aNd.aMZ;
        frameLayout.removeView(view2);
    }
}
