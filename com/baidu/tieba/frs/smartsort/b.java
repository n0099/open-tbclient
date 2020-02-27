package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.getLoadType() == 1;
    }

    public static boolean a(ArrayList<m> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData == null || v.isEmpty(arrayList) || StringUtils.isNull(str) || i < 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = arrayList.get(i2);
            if ((mVar instanceof CardHListViewData) && str.equals(((CardHListViewData) mVar).threadId)) {
                return false;
            }
        }
        int i3 = i + 1;
        if (i3 > 0) {
            v.add(arrayList, i3, cardHListViewData);
            return true;
        }
        return false;
    }
}
