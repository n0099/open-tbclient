package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
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
        boolean bhP = d.bhP();
        boolean z = !bhP && d.bhQ();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bhP) {
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
            bw bwVar = new bw();
            bwVar.eGT = true;
            bwVar.a(threadInfo);
            az(bwVar);
            arrayList.add(bwVar);
        }
        return dI(arrayList);
    }

    private static void az(bw bwVar) {
        String blX = bwVar.blX();
        String du = at.du(bwVar.bmt() * 1000);
        if (!TextUtils.isEmpty(blX) && !TextUtils.isEmpty(du)) {
            blX = blX + "   " + du;
        }
        bwVar.AZ(blX);
    }

    public static List<q> dI(List<bw> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (bw bwVar : list) {
            int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
            if (bwVar.getType() == bw.eDA) {
                bwVar.position = i2;
                bv bvVar = new bv();
                bvVar.exA = bwVar;
                bvVar.position = i2;
                bvVar.eDw = true;
                arrayList.add(bvVar);
                bv bvVar2 = new bv();
                bvVar2.exA = bwVar;
                bvVar2.position = i2;
                if (bwVar.bov()) {
                    bvVar2.eDl = true;
                } else if (bwVar.bnG() == 1) {
                    bvVar2.eDj = true;
                    bvVar2.eDx = imageWidthAndHeight[0];
                    bvVar2.eDy = imageWidthAndHeight[1];
                } else if (bwVar.bnG() >= 2) {
                    bvVar2.eDk = true;
                } else {
                    bvVar2.eDh = true;
                }
                arrayList.add(bvVar2);
                bv bvVar3 = new bv();
                bvVar3.eDm = true;
                bvVar3.exA = bwVar;
                bvVar3.position = i2;
                arrayList.add(bvVar3);
                i = i2 + 1;
            } else if (bwVar.getType() == bw.eDW) {
                bwVar.position = i2;
                bv bvVar4 = new bv();
                bvVar4.exA = bwVar;
                bvVar4.position = i2;
                bvVar4.eDw = true;
                arrayList.add(bvVar4);
                bv bvVar5 = new bv();
                bvVar5.exA = bwVar;
                bvVar5.position = i2;
                bvVar5.eDo = true;
                arrayList.add(bvVar5);
                bv bvVar6 = new bv();
                bvVar6.eDm = true;
                bvVar6.exA = bwVar;
                bvVar6.position = i2;
                arrayList.add(bvVar6);
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
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
                if (frsTabInfo != null && !at.isEmpty(frsTabInfo.tab_code) && !at.isEmpty(frsTabInfo.tab_name)) {
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
