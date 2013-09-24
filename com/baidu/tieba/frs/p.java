package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.f1157a = frsActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.ah ahVar;
        com.baidu.tieba.model.ah ahVar2;
        com.baidu.tieba.model.ah ahVar3;
        com.baidu.tieba.model.ah ahVar4;
        com.baidu.tieba.model.ah ahVar5;
        ba baVar;
        com.baidu.tieba.model.ah ahVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        ahVar = this.f1157a.E;
        if (ahVar != null) {
            ahVar2 = this.f1157a.E;
            ahVar2.a(longExtra);
            ahVar3 = this.f1157a.E;
            ahVar3.c(longExtra2);
            ahVar4 = this.f1157a.E;
            ahVar4.b(longExtra3);
            ahVar5 = this.f1157a.E;
            ahVar5.d(longExtra4);
            baVar = this.f1157a.o;
            ahVar6 = this.f1157a.E;
            baVar.a(ahVar6);
        }
    }
}
