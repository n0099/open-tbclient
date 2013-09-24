package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.f1125a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.ah ahVar;
        com.baidu.tieba.model.ah ahVar2;
        com.baidu.tieba.model.ah ahVar3;
        com.baidu.tieba.model.ah ahVar4;
        com.baidu.tieba.model.ah ahVar5;
        ay ayVar;
        com.baidu.tieba.model.ah ahVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        ahVar = this.f1125a.o;
        if (ahVar != null) {
            ahVar2 = this.f1125a.o;
            ahVar2.a(longExtra);
            ahVar3 = this.f1125a.o;
            ahVar3.c(longExtra2);
            ahVar4 = this.f1125a.o;
            ahVar4.b(longExtra3);
            ahVar5 = this.f1125a.o;
            ahVar5.d(longExtra4);
            ayVar = this.f1125a.m;
            ahVar6 = this.f1125a.o;
            ayVar.a(ahVar6);
        }
    }
}
