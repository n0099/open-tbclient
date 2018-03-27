package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.m;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<com.baidu.adp.widget.ListView.i> list, boolean z, int i) {
        if (!v.E(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.X(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.hC(forumData.getFirst_class());
                bVar2.hD(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.hE(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.cR(z);
            bVar2.je(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, m mVar, List<com.baidu.adp.widget.ListView.i> list, int i) {
        if (mVar != null) {
            a(bVar, mVar.bas(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.i> list, List<com.baidu.adp.widget.ListView.i> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && v.D(list) > 0 && v.D(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.haA) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(list, i);
                if (iVar != null && (indexOf = list2.indexOf(iVar)) >= 0) {
                    eVar.cG(i, indexOf);
                }
            }
        }
    }
}
