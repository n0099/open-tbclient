package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1456a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar, Activity activity) {
        this.b = sVar;
        this.f1456a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Register2Activity.a(this.f1456a, 12007);
    }
}
