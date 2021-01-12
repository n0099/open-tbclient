package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class c {
    public static List<n> a(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl == null || hotThreadListResIdl.data == null || x.isEmpty(hotThreadListResIdl.data.thread_info)) {
            return null;
        }
        boolean biE = d.biE();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (biE) {
            return dZ(list);
        }
        return dY(list);
    }

    private static List<n> dY(List<ThreadInfo> list) {
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

    private static List<n> dZ(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            bz bzVar = new bz();
            bzVar.eRx = true;
            bzVar.a(threadInfo);
            aC(bzVar);
            arrayList.add(bzVar);
        }
        return ea(arrayList);
    }

    private static void aC(bz bzVar) {
        String bmU = bzVar.bmU();
        String dT = at.dT(bzVar.bnq() * 1000);
        if (!TextUtils.isEmpty(bmU) && !TextUtils.isEmpty(dT)) {
            bmU = bmU + "   " + dT;
        }
        bzVar.zO(bmU);
    }

    public static List<n> ea(List<bz> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (bz bzVar : list) {
            int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
            if (bzVar.getType() == bz.eOa) {
                bzVar.position = i;
                by byVar = new by();
                byVar.eHK = bzVar;
                byVar.position = i;
                byVar.eNW = true;
                byVar.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(byVar);
                by byVar2 = new by();
                byVar2.eHK = bzVar;
                byVar2.position = i;
                if (bzVar.bpv()) {
                    byVar2.eNK = true;
                } else if (bzVar.boF() == 1) {
                    byVar2.eNI = true;
                    byVar2.eNX = imageWidthAndHeight[0];
                    byVar2.eNY = imageWidthAndHeight[1];
                } else if (bzVar.boF() >= 2) {
                    byVar2.eNJ = true;
                } else {
                    byVar2.eNG = true;
                }
                byVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(byVar2);
                by byVar3 = new by();
                byVar3.eNL = true;
                byVar3.eHK = bzVar;
                byVar3.position = i;
                byVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(byVar3);
                i++;
            } else if (bzVar.getType() == bz.eOy) {
                bzVar.position = i;
                by byVar4 = new by();
                byVar4.eHK = bzVar;
                byVar4.position = i;
                byVar4.eNW = true;
                byVar4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(byVar4);
                by byVar5 = new by();
                byVar5.eHK = bzVar;
                byVar5.position = i;
                byVar5.eNN = true;
                byVar5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(byVar5);
                by byVar6 = new by();
                byVar6.eNL = true;
                byVar6.eHK = bzVar;
                byVar6.position = i;
                byVar6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(byVar6);
                i++;
            }
            bzVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b eb(List<FrsTabInfo> list) {
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        ArrayList arrayList = new ArrayList();
        frsTabInfoData.tabList = arrayList;
        FrsTabItemData frsTabItemData = new FrsTabItemData();
        frsTabItemData.tabCode = "all";
        frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
        frsTabItemData.tabId = 0;
        arrayList.add(frsTabItemData);
        if (!x.isEmpty(list)) {
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
