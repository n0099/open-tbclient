package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsImageActivity frsImageActivity) {
        this.f840a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        ax axVar;
        com.baidu.tieba.model.aa aaVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        aaVar = this.f840a.p;
        if (aaVar != null) {
            aaVar2 = this.f840a.p;
            aaVar2.a(longExtra);
            aaVar3 = this.f840a.p;
            aaVar3.c(longExtra2);
            aaVar4 = this.f840a.p;
            aaVar4.b(longExtra3);
            aaVar5 = this.f840a.p;
            aaVar5.d(longExtra4);
            axVar = this.f840a.n;
            aaVar6 = this.f840a.p;
            axVar.a(aaVar6);
        }
    }
}
