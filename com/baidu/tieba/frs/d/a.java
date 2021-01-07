package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<n> list, boolean z, int i) {
        if (!x.isEmpty(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.bV(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.Fd(forumData.getFirst_class());
                bVar2.Fe(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.Ff(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.lV(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsViewData frsViewData, List<n> list, int i) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<n> list, List<n> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && x.getCount(list) > 0 && x.getCount(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.nqS) {
                n nVar = (n) x.getItem(list, i);
                if (nVar != null && (indexOf = list2.indexOf(nVar)) >= 0) {
                    fVar.du(i, indexOf);
                }
            }
        }
    }
}
