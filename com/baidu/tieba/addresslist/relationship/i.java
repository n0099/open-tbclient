package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class i extends BdAsyncTask<Void, Void, Void> {
    private a bqh;

    public i(a aVar) {
        this.bqh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!f.RN().a(this.bqh)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
