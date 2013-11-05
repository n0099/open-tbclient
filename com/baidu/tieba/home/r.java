package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1367a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, Activity activity) {
        this.b = pVar;
        this.f1367a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Register2Activity.a(this.f1367a, 12007);
    }
}
