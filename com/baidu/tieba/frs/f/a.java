package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.l;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<com.baidu.adp.widget.ListView.h> list, boolean z, int i) {
        if (!v.w(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.O(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.hv(forumData.getFirst_class());
                bVar2.hw(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.hx(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.ci(z);
            bVar2.gd(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, l lVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (lVar != null) {
            a(bVar, lVar.aVq(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.e eVar, List<com.baidu.adp.widget.ListView.h> list, List<com.baidu.adp.widget.ListView.h> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && v.v(list) > 0 && v.v(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.gvX) {
                com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(list, i);
                if (hVar != null && (indexOf = list2.indexOf(hVar)) >= 0) {
                    eVar.bI(i, indexOf);
                }
            }
        }
    }
}
