package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FrsActivity aLY;
    private final String name;

    public ag(FrsActivity frsActivity, String str) {
        this.aLY = frsActivity;
        this.name = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(com.baidu.tieba.frs.utils.a.I(this.aLY.getPageContext().getPageActivity(), this.name));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.aLY.showToast(com.baidu.tieba.t.shortcut_has_add);
        } else {
            this.aLY.gk(this.name);
        }
    }
}
