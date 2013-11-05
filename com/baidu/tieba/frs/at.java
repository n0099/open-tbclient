package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.f1263a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.ap apVar;
        com.baidu.tieba.model.ap apVar2;
        com.baidu.tieba.model.ap apVar3;
        com.baidu.tieba.model.ap apVar4;
        com.baidu.tieba.model.ap apVar5;
        ay ayVar;
        com.baidu.tieba.model.ap apVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        apVar = this.f1263a.o;
        if (apVar != null) {
            apVar2 = this.f1263a.o;
            apVar2.a(longExtra);
            apVar3 = this.f1263a.o;
            apVar3.c(longExtra2);
            apVar4 = this.f1263a.o;
            apVar4.b(longExtra3);
            apVar5 = this.f1263a.o;
            apVar5.d(longExtra4);
            ayVar = this.f1263a.m;
            apVar6 = this.f1263a.o;
            ayVar.a(apVar6);
        }
    }
}
