package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FrsActivity aBk;
    private final String name;

    public bc(FrsActivity frsActivity, String str) {
        this.aBk = frsActivity;
        this.name = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(com.baidu.tieba.frs.a.a.z(this.aBk, this.name));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.aBk.showToast(com.baidu.tieba.y.shortcut_has_add);
        } else {
            this.aBk.ff(this.name);
        }
    }
}
