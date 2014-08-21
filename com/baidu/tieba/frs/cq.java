package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FrsImageActivity a;
    private final String b;

    public cq(FrsImageActivity frsImageActivity, String str) {
        this.a = frsImageActivity;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        boolean b;
        b = this.a.b(this.b);
        return Boolean.valueOf(b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.a.showToast(com.baidu.tieba.x.shortcut_has_add);
        } else {
            this.a.c(this.b);
        }
    }
}
