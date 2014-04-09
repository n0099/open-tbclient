package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
final class ad implements View.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.a = faceBuyWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c();
    }
}
