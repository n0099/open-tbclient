package com.baidu.tieba;

import android.app.Application;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ ai a;
    private final /* synthetic */ Application b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ai aiVar, Application application) {
        this.a = aiVar;
        this.b = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.sendBroadcast(new Intent("com.baidu.tieba.action.PLUGIN_DOWNLOAD"));
    }
}
