package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, Void> {
    private a a;

    public o(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        if (!h.a().a(this.a)) {
            com.baidu.tbadk.core.sharedPref.b.a().b("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true);
            return null;
        }
        return null;
    }
}
