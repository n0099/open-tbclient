package com.baidu.tieba.enterForum.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.switchs.HttpsConnSwitch;
/* loaded from: classes9.dex */
public class b {
    public static boolean bSA() {
        if (j.isNetWorkAvailable()) {
            return SwitchManager.getInstance().findType(HttpsConnSwitch.KEY) == 1;
        }
        return false;
    }

    public static void bSB() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                    y yVar = new y("http://tiebac.baidu.com/empty.gif");
                    yVar.getNetData();
                    int i = yVar.isNetSuccess() ? 1 : 0;
                    y yVar2 = new y("https://tiebac.baidu.com/empty.gif");
                    yVar2.getNetData();
                    int i2 = yVar2.isNetSuccess() ? 1 : 0;
                    y yVar3 = new y("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                    yVar3.addPostData("is_success_http", String.valueOf(i));
                    yVar3.addPostData("is_success_https", String.valueOf(i2));
                    yVar3.postNetData();
                    TiebaStatic.log(new ao("c13734").ag("obj_locate", 1).ag("obj_type", i));
                    TiebaStatic.log(new ao("c13734").ag("obj_locate", 2).ag("obj_type", i2));
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(1);
        bdAsyncTask.execute(new Void[0]);
    }
}
