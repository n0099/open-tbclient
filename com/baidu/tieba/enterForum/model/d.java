package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes2.dex */
public class d {
    public static boolean aoL() {
        if (j.jD()) {
            return com.baidu.adp.lib.b.d.hv().aw("is_call_test_https") == 1;
        }
        return false;
    }

    public static void aoM() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                y yVar = new y("http://tiebac.baidu.com/empty.gif");
                yVar.yA();
                int i = yVar.za() ? 1 : 0;
                y yVar2 = new y("https://tiebac.baidu.com/empty.gif");
                yVar2.yA();
                int i2 = yVar2.za() ? 1 : 0;
                y yVar3 = new y("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                yVar3.o("is_success_http", String.valueOf(i));
                yVar3.o("is_success_https", String.valueOf(i2));
                yVar3.yz();
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
