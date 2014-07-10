package com.baidu.tieba.barcode;

import android.os.AsyncTask;
/* loaded from: classes.dex */
final class o extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ n a;

    private o(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(n nVar, o oVar) {
        this(nVar);
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(300000L);
            n.b(this.a).setResult(0);
            n.b(this.a).finish();
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
