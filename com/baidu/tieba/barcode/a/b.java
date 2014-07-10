package com.baidu.tieba.barcode.a;

import android.os.AsyncTask;
/* loaded from: classes.dex */
final class b extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ a a;

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
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
