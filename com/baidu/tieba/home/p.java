package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1501a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, Activity activity) {
        this.b = nVar;
        this.f1501a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Register2Activity.a(this.f1501a, 12007);
    }
}
