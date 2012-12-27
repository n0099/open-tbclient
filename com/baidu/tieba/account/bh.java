package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.j();
    }
}
