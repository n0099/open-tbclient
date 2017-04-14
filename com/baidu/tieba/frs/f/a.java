package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(TbPageContext tbPageContext, ForumData forumData, List<com.baidu.adp.widget.ListView.v> list, boolean z, int i) {
        if (!com.baidu.tbadk.core.util.x.q(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(tbPageContext, 5);
            bVar.G(list);
            if (forumData != null) {
                bVar.setForumId(forumData.getId());
                bVar.gw(forumData.getFirst_class());
                bVar.gx(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar.gy(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar.ch(z);
            bVar.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        }
    }

    public static void a(TbPageContext tbPageContext, FrsModelController frsModelController, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (frsModelController != null && frsModelController.acy() != null) {
            a(tbPageContext, frsModelController.acy().aJw(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.v> list, List<com.baidu.adp.widget.ListView.v> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && com.baidu.tbadk.core.util.x.p(list) > 0 && com.baidu.tbadk.core.util.x.p(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.fvr) {
                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    eVar.bn(i, indexOf);
                }
            }
        }
    }
}
