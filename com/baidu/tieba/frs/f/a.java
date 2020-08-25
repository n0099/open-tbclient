package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<q> list, boolean z, int i) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.bm(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.Db(forumData.getFirst_class());
                bVar2.Dc(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.Dd(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.kg(z);
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
        if (fVar != null && y.getCount(list) > 0 && y.getCount(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.mep) {
                q qVar = (q) y.getItem(list, i);
                if (qVar != null && (indexOf = list2.indexOf(qVar)) >= 0) {
                    fVar.dk(i, indexOf);
                }
            }
        }
    }
}
