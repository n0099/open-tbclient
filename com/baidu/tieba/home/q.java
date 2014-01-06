package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, Activity activity) {
        this.b = oVar;
        this.a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Register2Activity.a(this.a, 12007);
    }
}
