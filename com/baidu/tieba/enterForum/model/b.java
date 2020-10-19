package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.switchs.HttpsConnSwitch;
/* loaded from: classes22.dex */
public class b {
    public static boolean cmT() {
        if (j.isNetWorkAvailable()) {
            return SwitchManager.getInstance().findType(HttpsConnSwitch.KEY) == 1;
        }
        return false;
    }

    public static void cmU() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                    aa aaVar = new aa("http://tiebac.baidu.com/empty.gif");
                    aaVar.getNetData();
                    int i = aaVar.isNetSuccess() ? 1 : 0;
                    aa aaVar2 = new aa("https://tiebac.baidu.com/empty.gif");
                    aaVar2.getNetData();
                    int i2 = aaVar2.isNetSuccess() ? 1 : 0;
                    aa aaVar3 = new aa("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                    aaVar3.addPostData("is_success_http", String.valueOf(i));
                    aaVar3.addPostData("is_success_https", String.valueOf(i2));
                    aaVar3.postNetData();
                    TiebaStatic.log(new aq("c13734").aj("obj_locate", 1).aj("obj_type", i));
                    TiebaStatic.log(new aq("c13734").aj("obj_locate", 2).aj("obj_type", i2));
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
