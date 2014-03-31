package com.baidu.tieba.barcode;

import android.app.Activity;
import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ n a;

    private o(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(n nVar, byte b) {
        this(nVar);
    }

    @Override // android.os.AsyncTask
    protected final Object doInBackground(Object... objArr) {
        Activity activity;
        Activity activity2;
        try {
            Thread.sleep(300000L);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "doInBackground", "Finishing activity due to inactivity");
            activity = this.a.a;
            activity.setResult(0);
            activity2 = this.a.a;
            activity2.finish();
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
