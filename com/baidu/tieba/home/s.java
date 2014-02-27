package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
final class s implements View.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, Activity activity, int i, String str) {
        this.a = rVar;
        this.b = activity;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.a(this.b, this.c, this.d, 11003);
    }
}
