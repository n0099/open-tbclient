package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    public static void c(int i, l lVar) {
        if (lVar != null) {
            if (i == 3 || i == 6) {
                lVar.setLoadType(1);
            } else {
                lVar.setLoadType(2);
            }
        }
    }

    public static boolean b(l lVar) {
        return lVar != null && lVar.getLoadType() == 1;
    }

    public static boolean a(ArrayList<v> arrayList, String str, CardHListViewData cardHListViewData) {
        int i;
        if (cardHListViewData == null || x.t(arrayList) || StringUtils.isNull(str)) {
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
            if (!(vVar2 instanceof bg) || !TextUtils.equals(str, ((bg) vVar2).getId())) {
                i3++;
            } else {
                i = i3 + 1;
                break;
            }
        }
        if (i > 0) {
            x.a(arrayList, i, cardHListViewData);
            return true;
        }
        return false;
    }
}
