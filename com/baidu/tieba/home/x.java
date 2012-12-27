package com.baidu.tieba.home;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends AsyncTask {
    final /* synthetic */ MarkActivity a;

    private x(MarkActivity markActivity) {
        this.a = markActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(MarkActivity markActivity, x xVar) {
        this(markActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.h doInBackground(Object... objArr) {
        com.baidu.tieba.b.h hVar = new com.baidu.tieba.b.h();
        try {
            hVar.b();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "PbAsyncTask.doInBackground error = " + e.getMessage());
        }
        return hVar;
    }

    public void a() {
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.h hVar) {
        if (hVar == null) {
            this.a.b("");
        } else {
            this.a.f = hVar;
            this.a.k();
            System.gc();
        }
        this.a.e = null;
    }
}
