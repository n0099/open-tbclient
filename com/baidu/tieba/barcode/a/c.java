package com.baidu.tieba.barcode.a;

import android.os.AsyncTask;
/* loaded from: classes.dex */
final class c extends AsyncTask<Object, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1136a;

    private c(a aVar) {
        this.f1136a = aVar;
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
        synchronized (this.f1136a) {
            if (a.a(this.f1136a)) {
                this.f1136a.a();
            }
        }
        return null;
    }
}
