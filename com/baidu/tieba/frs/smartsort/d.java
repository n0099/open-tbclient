package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public static void c(int i, FrsRequestData frsRequestData) {
        if (frsRequestData != null) {
            if (i == 3 || i == 6) {
                frsRequestData.setLoadType(1);
            } else {
                frsRequestData.setLoadType(2);
            }
        }
    }

    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.getLoadType() == 1;
    }

    public static boolean a(ArrayList<v> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData == null || x.q(arrayList) || StringUtils.isNull(str) || i < 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = arrayList.get(i2);
            if ((vVar instanceof CardHListViewData) && str.equals(((CardHListViewData) vVar).threadId)) {
                return false;
            }
        }
        int i3 = i + 1;
        if (i3 > 0) {
            x.a(arrayList, i3, cardHListViewData);
            return true;
        }
        return false;
    }
}
