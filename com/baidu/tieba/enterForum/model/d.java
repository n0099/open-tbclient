package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class d {
    public static boolean acq() {
        if (i.hr()) {
            return com.baidu.adp.lib.b.d.fh().am("is_call_test_https") == 1;
        }
        return false;
    }

    public static void acr() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                w wVar = new w("http://tiebac.baidu.com/empty.gif");
                wVar.ug();
                int i = wVar.vp() ? 1 : 0;
                w wVar2 = new w("https://tiebac.baidu.com/empty.gif");
                wVar2.ug();
                int i2 = wVar2.vp() ? 1 : 0;
                w wVar3 = new w("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                wVar3.n("is_success_http", String.valueOf(i));
                wVar3.n("is_success_https", String.valueOf(i2));
                wVar3.uP();
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
