package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.w;
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

    public static boolean a(ArrayList<v> arrayList, String str, CardHListViewData cardHListViewData) {
        int i;
        if (cardHListViewData == null || w.s(arrayList) || StringUtils.isNull(str)) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = arrayList.get(i2);
            if ((vVar instanceof CardHListViewData) && str.equals(((CardHListViewData) vVar).threadId)) {
                return false;
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i = 0;
                break;
            }
            v vVar2 = arrayList.get(i3);
            if (!(vVar2 instanceof bh) || !TextUtils.equals(str, ((bh) vVar2).getId())) {
                i3++;
            } else {
                i = i3 + 1;
                break;
            }
        }
        if (i > 0) {
            w.a(arrayList, i, cardHListViewData);
            return true;
        }
        return false;
    }
}
