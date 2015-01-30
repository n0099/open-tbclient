package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r aQs;
    private final /* synthetic */ FrameLayout aQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, FrameLayout frameLayout) {
        this.aQs = rVar;
        this.aQt = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.aQt;
        view2 = this.aQs.aQr;
        frameLayout.removeView(view2);
    }
}
