package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.getLoadType() == 1;
    }

    public static boolean a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData == null || u.v(arrayList) || StringUtils.isNull(str) || i < 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
            if ((fVar instanceof CardHListViewData) && str.equals(((CardHListViewData) fVar).threadId)) {
                return false;
            }
        }
        int i3 = i + 1;
        if (i3 > 0) {
            u.a(arrayList, i3, cardHListViewData);
            return true;
        }
        return false;
    }
}
