package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r aQr;
    private final /* synthetic */ FrameLayout aQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, FrameLayout frameLayout) {
        this.aQr = rVar;
        this.aQs = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.aQs;
        view2 = this.aQr.aQq;
        frameLayout.removeView(view2);
    }
}
