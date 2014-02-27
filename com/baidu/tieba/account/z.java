package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.e();
        y.h(this.a);
    }
}
