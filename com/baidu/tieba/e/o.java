package com.baidu.tieba.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, Context context) {
        this.a = nVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.sendBroadcast(new Intent("com.baidu.tieba.SHOWSQUARE"));
    }
}
