package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.f1078a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.af afVar;
        com.baidu.tieba.model.af afVar2;
        com.baidu.tieba.model.af afVar3;
        com.baidu.tieba.model.af afVar4;
        com.baidu.tieba.model.af afVar5;
        az azVar;
        com.baidu.tieba.model.af afVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        afVar = this.f1078a.p;
        if (afVar != null) {
            afVar2 = this.f1078a.p;
            afVar2.a(longExtra);
            afVar3 = this.f1078a.p;
            afVar3.c(longExtra2);
            afVar4 = this.f1078a.p;
            afVar4.b(longExtra3);
            afVar5 = this.f1078a.p;
            afVar5.d(longExtra4);
            azVar = this.f1078a.n;
            afVar6 = this.f1078a.p;
            azVar.a(afVar6);
        }
    }
}
