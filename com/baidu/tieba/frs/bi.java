package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends BroadcastReceiver {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.model.ap apVar;
        com.baidu.tieba.model.ap apVar2;
        com.baidu.tieba.model.ap apVar3;
        com.baidu.tieba.model.ap apVar4;
        com.baidu.tieba.model.ap apVar5;
        bl blVar;
        com.baidu.tieba.model.ap apVar6;
        long longExtra = intent.getLongExtra("fans", 0L);
        long longExtra2 = intent.getLongExtra("relay", 0L);
        long longExtra3 = intent.getLongExtra("at_me", 0L);
        long longExtra4 = intent.getLongExtra("pletter", 0L);
        apVar = this.a.n;
        if (apVar != null) {
            apVar2 = this.a.n;
            apVar2.a(longExtra);
            apVar3 = this.a.n;
            apVar3.c(longExtra2);
            apVar4 = this.a.n;
            apVar4.b(longExtra3);
            apVar5 = this.a.n;
            apVar5.d(longExtra4);
            blVar = this.a.l;
            apVar6 = this.a.n;
            blVar.a(apVar6);
        }
    }
}
