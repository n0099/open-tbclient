package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, ForumData forumData, List<o> list, boolean z, int i) {
        if (!v.isEmpty(list)) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 5);
            bVar2.aY(list);
            if (forumData != null) {
                bVar2.setForumId(forumData.getId());
                bVar2.zg(forumData.getFirst_class());
                bVar2.zh(forumData.getSecond_class());
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                bVar2.zi(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
            }
            bVar2.iR(z);
            bVar2.setPageNum(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public static void a(com.baidu.tieba.InjectPlugin.a.b bVar, FrsViewData frsViewData, List<o> list, int i) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<o> list, List<o> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && v.getCount(list) > 0 && v.getCount(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.llt) {
                o oVar = (o) v.getItem(list, i);
                if (oVar != null && (indexOf = list2.indexOf(oVar)) >= 0) {
                    fVar.cU(i, indexOf);
                }
            }
        }
    }
}
