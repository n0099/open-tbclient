package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.mc.FrsModelController;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<com.baidu.adp.widget.ListView.f> list, boolean z, int i) {
        if (!v.w(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.O(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.hh(forumData.getFirst_class());
                bVar2.hi(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.hj(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.cl(z);
            bVar2.gn(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsModelController frsModelController, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (frsModelController != null && frsModelController.aoI() != null) {
            a(bVar, frsModelController.aoI().aRo(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && v.v(list) > 0 && v.v(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.gBv) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(list, i);
                if (fVar != null && (indexOf = list2.indexOf(fVar)) >= 0) {
                    eVar.bV(i, indexOf);
                }
            }
        }
    }
}
