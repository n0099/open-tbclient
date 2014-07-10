package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.dismiss();
    }
}
