package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<m> list, boolean z, int i) {
        if (!v.T(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.ao(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.qf(forumData.getFirst_class());
                bVar2.qg(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.qh(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.fC(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsViewData frsViewData, List<m> list, int i) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<m> list, List<m> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && v.S(list) > 0 && v.S(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.iFD) {
                m mVar = (m) v.c(list, i);
                if (mVar != null && (indexOf = list2.indexOf(mVar)) >= 0) {
                    fVar.cn(i, indexOf);
                }
            }
        }
    }
}
