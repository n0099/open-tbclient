package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1146a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, Activity activity, int i, String str) {
        this.f1146a = zVar;
        this.b = activity;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginActivity.a(this.b, this.c, this.d, 11003);
    }
}
