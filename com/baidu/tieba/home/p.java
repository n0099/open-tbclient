package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ FrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, FrameLayout frameLayout) {
        this.a = nVar;
        this.b = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        FrameLayout frameLayout = this.b;
        view2 = this.a.r;
        frameLayout.removeView(view2);
    }
}
