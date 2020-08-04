package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<q> list, boolean z, int i) {
        if (!x.isEmpty(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.bm(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.AH(forumData.getFirst_class());
                bVar2.AI(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.AJ(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.jI(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsViewData frsViewData, List<q> list, int i) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<q> list, List<q> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && x.getCount(list) > 0 && x.getCount(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.lMF) {
                q qVar = (q) x.getItem(list, i);
                if (qVar != null && (indexOf = list2.indexOf(qVar)) >= 0) {
                    fVar.dc(i, indexOf);
                }
            }
        }
    }
}
