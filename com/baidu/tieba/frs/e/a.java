package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<v> list, boolean z, int i) {
        if (!x.r(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.setThreadList(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.gt(forumData.getFirst_class());
                bVar2.gu(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.gv(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.cg(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsModelController frsModelController, List<v> list, int i) {
        if (frsModelController != null && frsModelController.acK() != null) {
            a(bVar, frsModelController.acK().aIz(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && x.q(list) > 0 && x.q(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.fBD) {
                v vVar = (v) x.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    eVar.bk(i, indexOf);
                }
            }
        }
    }
}
