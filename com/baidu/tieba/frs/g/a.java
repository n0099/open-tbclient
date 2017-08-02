package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<com.baidu.adp.widget.ListView.f> list, boolean z, int i) {
        if (!u.v(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.setThreadList(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.gW(forumData.getFirst_class());
                bVar2.gX(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.gY(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.cl(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsModelController frsModelController, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (frsModelController != null && frsModelController.ahK() != null) {
            a(bVar, frsModelController.ahK().aOW(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && u.u(list) > 0 && u.u(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.gge) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(list, i);
                if (fVar != null && (indexOf = list2.indexOf(fVar)) >= 0) {
                    eVar.bv(i, indexOf);
                }
            }
        }
    }
}
