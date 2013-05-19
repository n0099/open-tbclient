package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BroadcastReceiver {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.c.u uVar;
        ba baVar;
        com.baidu.tieba.c.u uVar2;
        com.baidu.tieba.c.u uVar3;
        com.baidu.tieba.c.u uVar4;
        com.baidu.tieba.c.u uVar5;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        uVar = this.a.C;
        if (uVar != null) {
            uVar3 = this.a.C;
            uVar3.a(longExtra);
            uVar4 = this.a.C;
            uVar4.c(longExtra2);
            uVar5 = this.a.C;
            uVar5.b(longExtra3);
        }
        baVar = this.a.l;
        uVar2 = this.a.C;
        baVar.a(uVar2);
    }
}
