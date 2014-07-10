package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p a;
    private final /* synthetic */ FrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, FrameLayout frameLayout) {
        this.a = pVar;
        this.b = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.b;
        view2 = this.a.o;
        frameLayout.removeView(view2);
    }
}
