package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Void, Void, Void> {
    private a My;

    public p(a aVar) {
        this.My = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!i.pE().a(this.My)) {
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
