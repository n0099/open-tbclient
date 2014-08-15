package com.baidu.tieba.faceshop;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ FaceBuyWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FaceBuyWebViewActivity faceBuyWebViewActivity) {
        this.a = faceBuyWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c();
    }
}
