package com.baidu.tieba.barcode;

import android.app.Activity;
import android.os.AsyncTask;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends AsyncTask<Object, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1156a;

    private q(o oVar) {
        this.f1156a = oVar;
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object... objArr) {
        Activity activity;
        Activity activity2;
        try {
            Thread.sleep(300000L);
            bd.a(getClass().getName(), "doInBackground", "Finishing activity due to inactivity");
            activity = this.f1156a.f1155a;
            activity.setResult(0);
            activity2 = this.f1156a.f1155a;
            activity2.finish();
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
