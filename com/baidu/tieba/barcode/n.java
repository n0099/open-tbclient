package com.baidu.tieba.barcode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public final class n {
    private final Activity a;
    private final com.baidu.tieba.barcode.b.a.a b = new com.baidu.tieba.barcode.b.a.b().a();
    private final BroadcastReceiver c = new p(this, (byte) 0);
    private o d;

    public n(Activity activity) {
        this.a = activity;
        a();
    }

    public final synchronized void a() {
        e();
        this.d = new o(this, (byte) 0);
        this.b.a(this.d, new Object[0]);
    }

    public final void b() {
        e();
        this.a.unregisterReceiver(this.c);
    }

    public final void c() {
        this.a.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        a();
    }

    public synchronized void e() {
        o oVar = this.d;
        if (oVar != null) {
            oVar.cancel(true);
            this.d = null;
        }
    }

    public final void d() {
        e();
    }
}
