package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.getLoadType() == 1;
    }

    public static boolean a(ArrayList<i> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData == null || v.G(arrayList) || StringUtils.isNull(str) || i < 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = arrayList.get(i2);
            if ((iVar instanceof CardHListViewData) && str.equals(((CardHListViewData) iVar).threadId)) {
                return false;
            }
        }
        int i3 = i + 1;
        if (i3 > 0) {
            v.a(arrayList, i3, cardHListViewData);
            return true;
        }
        return false;
    }
}
