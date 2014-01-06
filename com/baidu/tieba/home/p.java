package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ o d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, Activity activity, int i, String str) {
        this.d = oVar;
        this.a = activity;
        this.b = i;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginActivity.a(this.a, this.b, this.c, 11003);
    }
}
