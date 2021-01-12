package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.switchs.HttpsConnSwitch;
/* loaded from: classes2.dex */
public class b {
    public static boolean cvw() {
        if (j.isNetWorkAvailable()) {
            return SwitchManager.getInstance().findType(HttpsConnSwitch.KEY) == 1;
        }
        return false;
    }

    public static void cvx() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                    z zVar = new z("http://tiebac.baidu.com/empty.gif");
                    zVar.getNetData();
                    int i = zVar.isNetSuccess() ? 1 : 0;
                    z zVar2 = new z("https://tiebac.baidu.com/empty.gif");
                    zVar2.getNetData();
                    int i2 = zVar2.isNetSuccess() ? 1 : 0;
                    z zVar3 = new z("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                    zVar3.addPostData("is_success_http", String.valueOf(i));
                    zVar3.addPostData("is_success_https", String.valueOf(i2));
                    zVar3.postNetData();
                    TiebaStatic.log(new aq("c13734").an("obj_locate", 1).an("obj_type", i));
                    TiebaStatic.log(new aq("c13734").an("obj_locate", 2).an("obj_type", i2));
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
