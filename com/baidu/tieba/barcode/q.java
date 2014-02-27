package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class q extends BroadcastReceiver {
    final /* synthetic */ o a;

    private q(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, byte b) {
        this(oVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            if (intent.getIntExtra("plugged", -1) <= 0) {
                this.a.a();
            } else {
                o.a(this.a);
            }
        }
    }
}
