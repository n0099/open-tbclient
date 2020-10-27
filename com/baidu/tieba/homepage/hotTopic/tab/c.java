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
        boolean bfp = d.bfp();
        boolean z = !bfp && d.bfq();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (bfp) {
            return dx(list);
        }
        if (z) {
            return dz(list);
        }
        return dy(list);
    }

    private static List<q> dx(List<ThreadInfo> list) {
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

    private static List<q> dy(List<ThreadInfo> list) {
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

    private static List<q> dz(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.eBe = true;
            bwVar.a(threadInfo);
            az(bwVar);
            arrayList.add(bwVar);
        }
        return dA(arrayList);
    }

    private static void az(bw bwVar) {
        String bjx = bwVar.bjx();
        String cY = at.cY(bwVar.bjT() * 1000);
        if (!TextUtils.isEmpty(bjx) && !TextUtils.isEmpty(cY)) {
            bjx = bjx + "   " + cY;
        }
        bwVar.AL(bjx);
    }

    public static List<q> dA(List<bw> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (bw bwVar : list) {
            int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
            if (bwVar.getType() == bw.exJ) {
                bwVar.position = i2;
                bv bvVar = new bv();
                bvVar.erH = bwVar;
                bvVar.position = i2;
                bvVar.exF = true;
                arrayList.add(bvVar);
                bv bvVar2 = new bv();
                bvVar2.erH = bwVar;
                bvVar2.position = i2;
                if (bwVar.blV()) {
                    bvVar2.exu = true;
                } else if (bwVar.blg() == 1) {
                    bvVar2.exr = true;
                    bvVar2.exG = imageWidthAndHeight[0];
                    bvVar2.exH = imageWidthAndHeight[1];
                } else if (bwVar.blg() >= 2) {
                    bvVar2.exs = true;
                } else {
                    bvVar2.exp = true;
                }
                arrayList.add(bvVar2);
                bv bvVar3 = new bv();
                bvVar3.exv = true;
                bvVar3.erH = bwVar;
                bvVar3.position = i2;
                arrayList.add(bvVar3);
                i = i2 + 1;
            } else if (bwVar.getType() == bw.eyg) {
                bwVar.position = i2;
                bv bvVar4 = new bv();
                bvVar4.erH = bwVar;
                bvVar4.position = i2;
                bvVar4.exF = true;
                arrayList.add(bvVar4);
                bv bvVar5 = new bv();
                bvVar5.erH = bwVar;
                bvVar5.position = i2;
                bvVar5.exx = true;
                arrayList.add(bvVar5);
                bv bvVar6 = new bv();
                bvVar6.exv = true;
                bvVar6.erH = bwVar;
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

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b dB(List<FrsTabInfo> list) {
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
