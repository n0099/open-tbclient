package com.baidu.tieba.home;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends AsyncTask {
    final /* synthetic */ MarkActivity a;

    private ae(MarkActivity markActivity) {
        this.a = markActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(MarkActivity markActivity, ae aeVar) {
        this(markActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.i doInBackground(Object... objArr) {
        com.baidu.tieba.b.i iVar = new com.baidu.tieba.b.i();
        try {
            iVar.b();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "PbAsyncTask.doInBackground error = " + e.getMessage());
        }
        return iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.i iVar) {
        if (iVar != null) {
            this.a.g = iVar;
            this.a.m();
            System.gc();
        } else {
            this.a.b("");
        }
        this.a.f = null;
    }

    public void a() {
        super.cancel(true);
    }
}
