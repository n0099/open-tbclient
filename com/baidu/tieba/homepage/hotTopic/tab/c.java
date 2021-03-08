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
        boolean biS = d.biS();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (biS) {
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
            cbVar.eVk = true;
            cbVar.a(threadInfo);
            aD(cbVar);
            arrayList.add(cbVar);
        }
        return dX(arrayList);
    }

    private static void aD(cb cbVar) {
        String bnp = cbVar.bnp();
        String dZ = au.dZ(cbVar.bnL() * 1000);
        if (!TextUtils.isEmpty(bnp) && !TextUtils.isEmpty(dZ)) {
            bnp = bnp + "   " + dZ;
        }
        cbVar.Am(bnp);
    }

    public static List<n> dX(List<cb> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (cb cbVar : list) {
            int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
            if (cbVar.getType() == cb.eRN) {
                cbVar.position = i;
                ca caVar = new ca();
                caVar.eLr = cbVar;
                caVar.position = i;
                caVar.eRJ = true;
                caVar.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(caVar);
                ca caVar2 = new ca();
                caVar2.eLr = cbVar;
                caVar2.position = i;
                if (cbVar.bpP()) {
                    caVar2.eRx = true;
                } else if (cbVar.boZ() == 1) {
                    caVar2.eRv = true;
                    caVar2.eRK = imageWidthAndHeight[0];
                    caVar2.eRL = imageWidthAndHeight[1];
                } else if (cbVar.boZ() >= 2) {
                    caVar2.eRw = true;
                } else {
                    caVar2.eRt = true;
                }
                caVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(caVar2);
                ca caVar3 = new ca();
                caVar3.eRy = true;
                caVar3.eLr = cbVar;
                caVar3.position = i;
                caVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(caVar3);
                i++;
            } else if (cbVar.getType() == cb.eSl) {
                cbVar.position = i;
                ca caVar4 = new ca();
                caVar4.eLr = cbVar;
                caVar4.position = i;
                caVar4.eRJ = true;
                caVar4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(caVar4);
                ca caVar5 = new ca();
                caVar5.eLr = cbVar;
                caVar5.position = i;
                caVar5.eRA = true;
                caVar5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(caVar5);
                ca caVar6 = new ca();
                caVar6.eRy = true;
                caVar6.eLr = cbVar;
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
