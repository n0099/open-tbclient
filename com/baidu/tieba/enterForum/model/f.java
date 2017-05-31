package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
class f extends BdAsyncTask<Void, Void, Void> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        z zVar = new z("http://tiebac.baidu.com/empty.gif");
        zVar.uh();
        int i = zVar.uI() ? 1 : 0;
        z zVar2 = new z("https://tiebac.baidu.com/empty.gif");
        zVar2.uh();
        int i2 = zVar2.uI() ? 1 : 0;
        z zVar3 = new z("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
        zVar3.n("is_success_http", String.valueOf(i));
        zVar3.n("is_success_https", String.valueOf(i2));
        zVar3.ug();
        return null;
    }
}
