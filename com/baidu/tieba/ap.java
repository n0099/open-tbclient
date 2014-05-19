package com.baidu.tieba;

import android.app.Application;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ ad a;
    private final /* synthetic */ Application b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ad adVar, Application application) {
        this.a = adVar;
        this.b = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.sendBroadcast(new Intent("com.baidu.tieba.action.PLUGIN_DOWNLOAD"));
    }
}
