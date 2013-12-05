package com.baidu.tieba.barcode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a */
    private final Activity f1155a;
    private final com.baidu.tieba.barcode.b.a.a b = new com.baidu.tieba.barcode.b.a.b().a();
    private final BroadcastReceiver c = new r(this);
    private q d;

    public o(Activity activity) {
        this.f1155a = activity;
        a();
    }

    public synchronized void a() {
        e();
        this.d = new q(this);
        this.b.a(this.d, new Object[0]);
    }

    public void b() {
        e();
        this.f1155a.unregisterReceiver(this.c);
    }

    public void c() {
        this.f1155a.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        a();
    }

    public synchronized void e() {
        q qVar = this.d;
        if (qVar != null) {
            qVar.cancel(true);
            this.d = null;
        }
    }

    public void d() {
        e();
    }
}
