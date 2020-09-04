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
/* loaded from: classes16.dex */
public class c {
    public static List<q> a(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl == null || hotThreadListResIdl.data == null || y.isEmpty(hotThreadListResIdl.data.thread_info)) {
            return null;
        }
        boolean bab = d.bab();
        boolean z = !bab && d.bac();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bab) {
            return dd(list);
        }
        if (z) {
            return df(list);
        }
        return de(list);
    }

    private static List<q> dd(List<ThreadInfo> list) {
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

    private static List<q> de(List<ThreadInfo> list) {
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

    private static List<q> df(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.eeo = true;
            bwVar.a(threadInfo);
            ay(bwVar);
            arrayList.add(bwVar);
        }
        return dg(arrayList);
    }

    private static void ay(bw bwVar) {
        String beb = bwVar.beb();
        String cN = at.cN(bwVar.bex() * 1000);
        if (!TextUtils.isEmpty(beb) && !TextUtils.isEmpty(cN)) {
            beb = beb + "   " + cN;
        }
        bwVar.zl(beb);
    }

    public static List<q> dg(List<bw> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (bw bwVar : list) {
            int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
            if (bwVar.getType() == bw.eaW) {
                bwVar.position = i2;
                bv bvVar = new bv();
                bvVar.dUW = bwVar;
                bvVar.position = i2;
                bvVar.eaS = true;
                arrayList.add(bvVar);
                bv bvVar2 = new bv();
                bvVar2.dUW = bwVar;
                bvVar2.position = i2;
                if (bwVar.bgz()) {
                    bvVar2.eaH = true;
                } else if (bwVar.bfK() == 1) {
                    bvVar2.eaF = true;
                    bvVar2.eaT = imageWidthAndHeight[0];
                    bvVar2.eaU = imageWidthAndHeight[1];
                } else if (bwVar.bfK() >= 2) {
                    bvVar2.eaG = true;
                } else {
                    bvVar2.eaD = true;
                }
                arrayList.add(bvVar2);
                bv bvVar3 = new bv();
                bvVar3.eaI = true;
                bvVar3.dUW = bwVar;
                bvVar3.position = i2;
                arrayList.add(bvVar3);
                i = i2 + 1;
            } else if (bwVar.getType() == bw.ebs) {
                bwVar.position = i2;
                bv bvVar4 = new bv();
                bvVar4.dUW = bwVar;
                bvVar4.position = i2;
                bvVar4.eaS = true;
                arrayList.add(bvVar4);
                bv bvVar5 = new bv();
                bvVar5.dUW = bwVar;
                bvVar5.position = i2;
                bvVar5.eaK = true;
                arrayList.add(bvVar5);
                bv bvVar6 = new bv();
                bvVar6.eaI = true;
                bvVar6.dUW = bwVar;
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

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b dh(List<FrsTabInfo> list) {
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
