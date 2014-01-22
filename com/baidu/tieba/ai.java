package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BroadcastReceiver {
    final String a = "reason";
    final String b = "globalactions";
    final String c = "recentapps";
    final String d = "homekey";
    final /* synthetic */ ah e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.e = ahVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        String action = intent.getAction();
        if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null) {
            Log.e("HomeWatcher", "action:" + action + ",reason:" + stringExtra);
            ajVar = this.e.d;
            if (ajVar != null) {
                if (stringExtra.equals("homekey")) {
                    ajVar3 = this.e.d;
                    ajVar3.a();
                } else if (stringExtra.equals("recentapps")) {
                    ajVar2 = this.e.d;
                    ajVar2.b();
                }
            }
        }
    }
}
