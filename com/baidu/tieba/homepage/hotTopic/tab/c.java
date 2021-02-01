package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
        if (hotThreadListResIdl == null || hotThreadListResIdl.data == null || y.isEmpty(hotThreadListResIdl.data.thread_info)) {
            return null;
        }
        boolean biQ = d.biQ();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (biQ) {
            return dW(list);
        }
        return dV(list);
    }

    private static List<n> dV(List<ThreadInfo> list) {
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

    private static List<n> dW(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            cb cbVar = new cb();
            cbVar.eTJ = true;
            cbVar.a(threadInfo);
            aD(cbVar);
            arrayList.add(cbVar);
        }
        return dX(arrayList);
    }

    private static void aD(cb cbVar) {
        String bnn = cbVar.bnn();
        String dZ = au.dZ(cbVar.bnJ() * 1000);
        if (!TextUtils.isEmpty(bnn) && !TextUtils.isEmpty(dZ)) {
            bnn = bnn + "   " + dZ;
        }
        cbVar.Af(bnn);
    }

    public static List<n> dX(List<cb> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (cb cbVar : list) {
            int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
            if (cbVar.getType() == cb.eQm) {
                cbVar.position = i;
                ca caVar = new ca();
                caVar.eJQ = cbVar;
                caVar.position = i;
                caVar.eQi = true;
                caVar.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(caVar);
                ca caVar2 = new ca();
                caVar2.eJQ = cbVar;
                caVar2.position = i;
                if (cbVar.bpN()) {
                    caVar2.ePW = true;
                } else if (cbVar.boX() == 1) {
                    caVar2.ePU = true;
                    caVar2.eQj = imageWidthAndHeight[0];
                    caVar2.eQk = imageWidthAndHeight[1];
                } else if (cbVar.boX() >= 2) {
                    caVar2.ePV = true;
                } else {
                    caVar2.ePS = true;
                }
                caVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(caVar2);
                ca caVar3 = new ca();
                caVar3.ePX = true;
                caVar3.eJQ = cbVar;
                caVar3.position = i;
                caVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(caVar3);
                i++;
            } else if (cbVar.getType() == cb.eQK) {
                cbVar.position = i;
                ca caVar4 = new ca();
                caVar4.eJQ = cbVar;
                caVar4.position = i;
                caVar4.eQi = true;
                caVar4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(caVar4);
                ca caVar5 = new ca();
                caVar5.eJQ = cbVar;
                caVar5.position = i;
                caVar5.ePZ = true;
                caVar5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(caVar5);
                ca caVar6 = new ca();
                caVar6.ePX = true;
                caVar6.eJQ = cbVar;
                caVar6.position = i;
                caVar6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(caVar6);
                i++;
            }
            cbVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static com.baidu.tieba.homepage.hotTopic.tab.b.b dY(List<FrsTabInfo> list) {
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
