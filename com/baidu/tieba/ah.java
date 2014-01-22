package com.baidu.tieba;

import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public class ah {
    final /* synthetic */ GuideActivity a;
    private Context b;
    private IntentFilter c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private aj d;
    private ai e;

    public ah(GuideActivity guideActivity, Context context) {
        this.a = guideActivity;
        this.b = context;
    }

    public void a(aj ajVar) {
        this.d = ajVar;
        this.e = new ai(this);
    }

    public void a() {
        if (this.e != null) {
            this.b.registerReceiver(this.e, this.c);
        }
    }

    public void b() {
        if (this.e != null) {
            this.b.unregisterReceiver(this.e);
        }
    }
}
