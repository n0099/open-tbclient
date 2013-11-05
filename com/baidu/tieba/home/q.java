package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1366a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ p d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Activity activity, int i, String str) {
        this.d = pVar;
        this.f1366a = activity;
        this.b = i;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginActivity.a(this.f1366a, this.b, this.c, 11003);
    }
}
