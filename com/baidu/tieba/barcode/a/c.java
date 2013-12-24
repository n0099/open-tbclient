package com.baidu.tieba.barcode.a;

import android.os.AsyncTask;
/* loaded from: classes.dex */
final class c extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
        synchronized (this.a) {
            if (a.a(this.a)) {
                this.a.a();
            }
        }
        return null;
    }
}
