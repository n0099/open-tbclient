package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1220a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Activity activity, int i, String str) {
        this.f1220a = lVar;
        this.b = activity;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginActivity.a(this.b, this.c, this.d, 11003);
    }
}
