package com.baidu.tieba.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BroadcastReceiver {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "com.baidu.tieba.SHOWSQUARE") {
            this.a.e(0);
        }
    }
}
