package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1353a;
    final /* synthetic */ Context b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, i iVar, Context context) {
        this.c = nVar;
        this.f1353a = iVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.sendBroadcast(new Intent("com.baidu.tieba.SHOWSQUARE"));
    }
}
