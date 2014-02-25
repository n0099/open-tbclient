package com.baidu.tieba.barcode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public final class o {
    private final Activity a;
    private final com.baidu.tieba.barcode.b.a.a b = new com.baidu.tieba.barcode.b.a.b().a();
    private final BroadcastReceiver c = new q(this, null);
    private p d;

    public o(Activity activity) {
        this.a = activity;
        a();
    }

    public synchronized void a() {
        e();
        this.d = new p(this, null);
        this.b.a(this.d, new Object[0]);
    }

    public void b() {
        e();
        this.a.unregisterReceiver(this.c);
    }

    public void c() {
        this.a.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        a();
    }

    public synchronized void e() {
        p pVar = this.d;
        if (pVar != null) {
            pVar.cancel(true);
            this.d = null;
        }
    }

    public void d() {
        e();
    }
}
