package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class r extends BroadcastReceiver {
    final /* synthetic */ o a;

    private r(o oVar) {
        this.a = oVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            if (intent.getIntExtra("plugged", -1) <= 0) {
                this.a.a();
            } else {
                o.a(this.a);
            }
        }
    }
}
