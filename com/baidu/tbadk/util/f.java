package com.baidu.tbadk.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ d aqy;

    private f(d dVar) {
        this.aqy = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(d dVar, f fVar) {
        this(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(d.a(this.aqy));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (d.b(this.aqy) != null && bool != null) {
            d.b(this.aqy).aa(bool.booleanValue());
        }
    }
}
