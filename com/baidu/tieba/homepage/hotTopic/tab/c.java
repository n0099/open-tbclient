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
        boolean bdw = d.bdw();
        boolean z = !bdw && d.bdx();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bdw) {
            return m40do(list);
        }
        if (z) {
            return dq(list);
        }
        return dp(list);
    }

    /* renamed from: do  reason: not valid java name */
    private static List<q> m40do(List<ThreadInfo> list) {
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

    private static List<q> dp(List<ThreadInfo> list) {
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

    private static List<q> dq(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.esE = true;
            bwVar.a(threadInfo);
            az(bwVar);
            arrayList.add(bwVar);
        }
        return dr(arrayList);
    }

    private static void az(bw bwVar) {
        String bhE = bwVar.bhE();
        String cW = at.cW(bwVar.bia() * 1000);
        if (!TextUtils.isEmpty(bhE) && !TextUtils.isEmpty(cW)) {
            bhE = bhE + "   " + cW;
        }
        bwVar.As(bhE);
    }

    public static List<q> dr(List<bw> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (bw bwVar : list) {
            int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
            if (bwVar.getType() == bw.epl) {
                bwVar.position = i2;
                bv bvVar = new bv();
                bvVar.eji = bwVar;
                bvVar.position = i2;
                bvVar.eph = true;
                arrayList.add(bvVar);
                bv bvVar2 = new bv();
                bvVar2.eji = bwVar;
                bvVar2.position = i2;
                if (bwVar.bkc()) {
                    bvVar2.eoW = true;
                } else if (bwVar.bjn() == 1) {
                    bvVar2.eoU = true;
                    bvVar2.epi = imageWidthAndHeight[0];
                    bvVar2.epj = imageWidthAndHeight[1];
                } else if (bwVar.bjn() >= 2) {
                    bvVar2.eoV = true;
                } else {
                    bvVar2.eoS = true;
                }
                arrayList.add(bvVar2);
                bv bvVar3 = new bv();
                bvVar3.eoX = true;
                bvVar3.eji = bwVar;
                bvVar3.position = i2;
                arrayList.add(bvVar3);
                i = i2 + 1;
            } else if (bwVar.getType() == bw.epH) {
                bwVar.position = i2;
                bv bvVar4 = new bv();
                bvVar4.eji = bwVar;
                bvVar4.position = i2;
                bvVar4.eph = true;
                arrayList.add(bvVar4);
                bv bvVar5 = new bv();
                bvVar5.eji = bwVar;
                bvVar5.position = i2;
                bvVar5.eoZ = true;
                arrayList.add(bvVar5);
                bv bvVar6 = new bv();
                bvVar6.eoX = true;
                bvVar6.eji = bwVar;
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

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b ds(List<FrsTabInfo> list) {
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
