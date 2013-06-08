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
        com.baidu.tieba.c.x xVar;
        com.baidu.tieba.c.x xVar2;
        com.baidu.tieba.c.x xVar3;
        com.baidu.tieba.c.x xVar4;
        com.baidu.tieba.c.x xVar5;
        ba baVar;
        com.baidu.tieba.c.x xVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        xVar = this.a.C;
        if (xVar != null) {
            xVar2 = this.a.C;
            xVar2.a(longExtra);
            xVar3 = this.a.C;
            xVar3.c(longExtra2);
            xVar4 = this.a.C;
            xVar4.b(longExtra3);
            xVar5 = this.a.C;
            xVar5.d(longExtra4);
            baVar = this.a.l;
            xVar6 = this.a.C;
            baVar.a(xVar6);
        }
    }
}
