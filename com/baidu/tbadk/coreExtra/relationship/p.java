package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Void, Void, Void> {
    private a Sr;

    public p(a aVar) {
        this.Sr = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!i.sY().a(this.Sr)) {
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
