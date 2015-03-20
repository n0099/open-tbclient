package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Void, Void, Void> {
    private a azF;

    public m(a aVar) {
        this.azF = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!g.Fo().a(this.azF)) {
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
