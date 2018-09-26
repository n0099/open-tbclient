package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes2.dex */
public class d {
    public static boolean ara() {
        if (j.kK()) {
            return com.baidu.adp.lib.b.d.iB().aO("is_call_test_https") == 1;
        }
        return false;
    }

    public static void arb() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                x xVar = new x("http://tiebac.baidu.com/empty.gif");
                xVar.zu();
                int i = xVar.zU() ? 1 : 0;
                x xVar2 = new x("https://tiebac.baidu.com/empty.gif");
                xVar2.zu();
                int i2 = xVar2.zU() ? 1 : 0;
                x xVar3 = new x("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                xVar3.u("is_success_http", String.valueOf(i));
                xVar3.u("is_success_https", String.valueOf(i2));
                xVar3.zt();
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
