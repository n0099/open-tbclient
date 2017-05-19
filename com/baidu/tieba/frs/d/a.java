package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(TbPageContext tbPageContext, ForumData forumData, List<v> list, boolean z, int i) {
        if (!x.r(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(tbPageContext, 5);
            bVar.I(list);
            if (forumData != null) {
                bVar.setForumId(forumData.getId());
                bVar.gu(forumData.getFirst_class());
                bVar.gv(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar.gw(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar.cj(z);
            bVar.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        }
    }

    public static void a(TbPageContext tbPageContext, FrsModelController frsModelController, List<v> list, int i) {
        if (frsModelController != null && frsModelController.abG() != null) {
            a(tbPageContext, frsModelController.abG().aHE(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && x.q(list) > 0 && x.q(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.ftM) {
                v vVar = (v) x.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    eVar.bk(i, indexOf);
                }
            }
        }
    }
}
