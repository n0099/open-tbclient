package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
import com.baidu.tieba.homepage.hotTopic.tab.b.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class c {
    public static List<q> a(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl == null || hotThreadListResIdl.data == null || y.isEmpty(hotThreadListResIdl.data.thread_info)) {
            return null;
        }
        boolean bhg = d.bhg();
        boolean z = !bhg && d.bhh();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bhg) {
            return dF(list);
        }
        if (z) {
            return dH(list);
        }
        return dG(list);
    }

    private static List<q> dF(List<ThreadInfo> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo == null || TextUtils.isEmpty(threadInfo.title)) {
                i = i3;
            } else {
                arrayList.add(new f(threadInfo, i3));
                i = i3 + 1;
            }
            i2++;
            i3 = i;
        }
        return arrayList;
    }

    private static List<q> dG(List<ThreadInfo> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo == null || TextUtils.isEmpty(threadInfo.title)) {
                i = i3;
            } else {
                arrayList.add(new e(threadInfo, i3));
                i = i3 + 1;
            }
            i2++;
            i3 = i;
        }
        return arrayList;
    }

    private static List<q> dH(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            bx bxVar = new bx();
            bxVar.eFl = true;
            bxVar.a(threadInfo);
            aB(bxVar);
            arrayList.add(bxVar);
        }
        return dI(arrayList);
    }

    private static void aB(bx bxVar) {
        String bkZ = bxVar.bkZ();
        String du = au.du(bxVar.blv() * 1000);
        if (!TextUtils.isEmpty(bkZ) && !TextUtils.isEmpty(du)) {
            bkZ = bkZ + "   " + du;
        }
        bxVar.Au(bkZ);
    }

    public static List<q> dI(List<bx> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (bx bxVar : list) {
            int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
            if (bxVar.getType() == bx.eBR) {
                bxVar.position = i;
                bw bwVar = new bw();
                bwVar.evQ = bxVar;
                bwVar.position = i;
                bwVar.eBN = true;
                bwVar.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(bwVar);
                bw bwVar2 = new bw();
                bwVar2.evQ = bxVar;
                bwVar2.position = i;
                if (bxVar.bnz()) {
                    bwVar2.eBC = true;
                } else if (bxVar.bmK() == 1) {
                    bwVar2.eBA = true;
                    bwVar2.eBO = imageWidthAndHeight[0];
                    bwVar2.eBP = imageWidthAndHeight[1];
                } else if (bxVar.bmK() >= 2) {
                    bwVar2.eBB = true;
                } else {
                    bwVar2.eBy = true;
                }
                bwVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(bwVar2);
                bw bwVar3 = new bw();
                bwVar3.eBD = true;
                bwVar3.evQ = bxVar;
                bwVar3.position = i;
                bwVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(bwVar3);
                i++;
            } else if (bxVar.getType() == bx.eCo) {
                bxVar.position = i;
                bw bwVar4 = new bw();
                bwVar4.evQ = bxVar;
                bwVar4.position = i;
                bwVar4.eBN = true;
                bwVar4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(bwVar4);
                bw bwVar5 = new bw();
                bwVar5.evQ = bxVar;
                bwVar5.position = i;
                bwVar5.eBF = true;
                bwVar5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(bwVar5);
                bw bwVar6 = new bw();
                bwVar6.eBD = true;
                bwVar6.evQ = bxVar;
                bwVar6.position = i;
                bwVar6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(bwVar6);
                i++;
            }
            bxVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b dJ(List<FrsTabInfo> list) {
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        ArrayList arrayList = new ArrayList();
        frsTabInfoData.tabList = arrayList;
        FrsTabItemData frsTabItemData = new FrsTabItemData();
        frsTabItemData.tabCode = "all";
        frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
        frsTabItemData.tabId = 0;
        arrayList.add(frsTabItemData);
        if (!y.isEmpty(list)) {
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !au.isEmpty(frsTabInfo.tab_code) && !au.isEmpty(frsTabInfo.tab_name)) {
                    i++;
                    FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                    frsTabItemData2.tabId = i;
                    arrayList.add(frsTabItemData2);
                }
            }
        }
        return new com.baidu.tieba.homepage.hotTopic.tab.b.b(frsTabInfoData);
    }
}
