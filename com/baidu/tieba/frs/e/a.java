package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<v> list, boolean z, int i) {
        if (!z.t(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.setThreadList(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.gQ(forumData.getFirst_class());
                bVar2.gR(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.gS(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.ci(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsModelController frsModelController, List<v> list, int i) {
        if (frsModelController != null && frsModelController.agC() != null) {
            a(bVar, frsModelController.agC().aMt(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && z.s(list) > 0 && z.s(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.fLH) {
                v vVar = (v) z.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    eVar.bt(i, indexOf);
                }
            }
        }
    }
}
