package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.getLoadType() == 1;
    }

    public static boolean a(ArrayList<h> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData == null || w.A(arrayList) || StringUtils.isNull(str) || i < 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = arrayList.get(i2);
            if ((hVar instanceof CardHListViewData) && str.equals(((CardHListViewData) hVar).threadId)) {
                return false;
            }
        }
        int i3 = i + 1;
        if (i3 > 0) {
            w.a(arrayList, i3, cardHListViewData);
            return true;
        }
        return false;
    }
}
