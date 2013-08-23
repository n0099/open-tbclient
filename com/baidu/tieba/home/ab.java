package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1147a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, Activity activity) {
        this.f1147a = zVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Register2Activity.a(this.b, 12007);
    }
}
