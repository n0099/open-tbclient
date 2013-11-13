package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.f1348a = frsActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.ap apVar;
        com.baidu.tieba.model.ap apVar2;
        com.baidu.tieba.model.ap apVar3;
        com.baidu.tieba.model.ap apVar4;
        com.baidu.tieba.model.ap apVar5;
        bn bnVar;
        com.baidu.tieba.model.ap apVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        apVar = this.f1348a.E;
        if (apVar != null) {
            apVar2 = this.f1348a.E;
            apVar2.a(longExtra);
            apVar3 = this.f1348a.E;
            apVar3.c(longExtra2);
            apVar4 = this.f1348a.E;
            apVar4.b(longExtra3);
            apVar5 = this.f1348a.E;
            apVar5.d(longExtra4);
            bnVar = this.f1348a.n;
            apVar6 = this.f1348a.E;
            bnVar.a(apVar6);
        }
    }
}
