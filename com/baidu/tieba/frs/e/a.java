package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.l;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<com.baidu.adp.widget.ListView.i> list, boolean z, int i) {
        if (!v.E(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.V(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.hl(forumData.getFirst_class());
                bVar2.hm(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.hn(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.cM(z);
            bVar2.ji(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, l lVar, List<com.baidu.adp.widget.ListView.i> list, int i) {
        if (lVar != null) {
            a(bVar, lVar.aYE(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.i> list, List<com.baidu.adp.widget.ListView.i> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && v.D(list) > 0 && v.D(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.gXI) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(list, i);
                if (iVar != null && (indexOf = list2.indexOf(iVar)) >= 0) {
                    eVar.cL(i, indexOf);
                }
            }
        }
    }
}
