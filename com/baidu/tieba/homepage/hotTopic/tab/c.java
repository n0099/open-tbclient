package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class c {
    public static List<q> a(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl == null || hotThreadListResIdl.data == null || y.isEmpty(hotThreadListResIdl.data.thread_info)) {
            return null;
        }
        boolean bkk = d.bkk();
        boolean z = !bkk && d.bkl();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bkk) {
            return dQ(list);
        }
        if (z) {
            return dS(list);
        }
        return dR(list);
    }

    private static List<q> dQ(List<ThreadInfo> list) {
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

    private static List<q> dR(List<ThreadInfo> list) {
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

    private static List<q> dS(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            by byVar = new by();
            byVar.eMn = true;
            byVar.a(threadInfo);
            aB(byVar);
            arrayList.add(byVar);
        }
        return dT(arrayList);
    }

    private static void aB(by byVar) {
        String bom = byVar.bom();
        String dT = au.dT(byVar.boI() * 1000);
        if (!TextUtils.isEmpty(bom) && !TextUtils.isEmpty(dT)) {
            bom = bom + "   " + dT;
        }
        byVar.Bb(bom);
    }

    public static List<q> dT(List<by> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (by byVar : list) {
            int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
            if (byVar.getType() == by.eIS) {
                byVar.position = i;
                bx bxVar = new bx();
                bxVar.eCR = byVar;
                bxVar.position = i;
                bxVar.eIO = true;
                bxVar.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(bxVar);
                bx bxVar2 = new bx();
                bxVar2.eCR = byVar;
                bxVar2.position = i;
                if (byVar.bqM()) {
                    bxVar2.eID = true;
                } else if (byVar.bpX() == 1) {
                    bxVar2.eIB = true;
                    bxVar2.eIP = imageWidthAndHeight[0];
                    bxVar2.eIQ = imageWidthAndHeight[1];
                } else if (byVar.bpX() >= 2) {
                    bxVar2.eIC = true;
                } else {
                    bxVar2.eIz = true;
                }
                bxVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(bxVar2);
                bx bxVar3 = new bx();
                bxVar3.eIE = true;
                bxVar3.eCR = byVar;
                bxVar3.position = i;
                bxVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(bxVar3);
                i++;
            } else if (byVar.getType() == by.eJq) {
                byVar.position = i;
                bx bxVar4 = new bx();
                bxVar4.eCR = byVar;
                bxVar4.position = i;
                bxVar4.eIO = true;
                bxVar4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(bxVar4);
                bx bxVar5 = new bx();
                bxVar5.eCR = byVar;
                bxVar5.position = i;
                bxVar5.eIG = true;
                bxVar5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(bxVar5);
                bx bxVar6 = new bx();
                bxVar6.eIE = true;
                bxVar6.eCR = byVar;
                bxVar6.position = i;
                bxVar6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(bxVar6);
                i++;
            }
            byVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b dU(List<FrsTabInfo> list) {
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
