package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
class g extends BdAsyncTask<Void, Void, Void> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        y yVar = new y("http://tiebac.baidu.com/empty.gif");
        yVar.ue();
        int i = yVar.uF() ? 1 : 0;
        y yVar2 = new y("https://tiebac.baidu.com/empty.gif");
        yVar2.ue();
        int i2 = yVar2.uF() ? 1 : 0;
        y yVar3 = new y("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
        yVar3.n("is_success_http", String.valueOf(i));
        yVar3.n("is_success_https", String.valueOf(i2));
        yVar3.ud();
        return null;
    }
}
