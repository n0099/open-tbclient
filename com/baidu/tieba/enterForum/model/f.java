package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
class f extends BdAsyncTask<Void, Void, Void> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        ab abVar = new ab("http://tiebac.baidu.com/empty.gif");
        abVar.tP();
        int i = abVar.uY() ? 1 : 0;
        ab abVar2 = new ab("https://tiebac.baidu.com/empty.gif");
        abVar2.tP();
        int i2 = abVar2.uY() ? 1 : 0;
        ab abVar3 = new ab("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
        abVar3.n("is_success_http", String.valueOf(i));
        abVar3.n("is_success_https", String.valueOf(i2));
        abVar3.uy();
        return null;
    }
}
