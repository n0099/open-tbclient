package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BroadcastReceiver {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.c.u uVar;
        ay ayVar;
        com.baidu.tieba.c.u uVar2;
        com.baidu.tieba.c.u uVar3;
        com.baidu.tieba.c.u uVar4;
        com.baidu.tieba.c.u uVar5;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        uVar = this.a.p;
        if (uVar != null) {
            uVar3 = this.a.p;
            uVar3.a(longExtra);
            uVar4 = this.a.p;
            uVar4.c(longExtra2);
            uVar5 = this.a.p;
            uVar5.b(longExtra3);
        }
        ayVar = this.a.n;
        uVar2 = this.a.p;
        ayVar.a(uVar2);
    }
}
