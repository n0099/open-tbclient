package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class i extends BdAsyncTask<Void, Void, Void> {
    private a ghJ;

    public i(a aVar) {
        this.ghJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!f.bLM().a(this.ghJ)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
