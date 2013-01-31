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
    public com.baidu.tieba.b.h doInBackground(Object... objArr) {
        com.baidu.tieba.b.h hVar = new com.baidu.tieba.b.h();
        try {
            hVar.b();
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "", "PbAsyncTask.doInBackground error = " + e.getMessage());
        }
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.h hVar) {
        if (hVar != null) {
            this.a.g = hVar;
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
