package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class p extends BroadcastReceiver {
    final /* synthetic */ n this$0;

    private p(n nVar) {
        this.this$0 = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(n nVar, p pVar) {
        this(nVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            if (intent.getIntExtra("plugged", -1) <= 0) {
                this.this$0.a();
            } else {
                n.a(this.this$0);
            }
        }
    }
}
