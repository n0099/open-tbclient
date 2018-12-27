package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bvB = new SparseArray<>();
    private Object bvC;
    private int bvD;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bvB.get(this.bvD);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object TL() {
        return this.bvC;
    }

    public void P(Object obj) {
        this.bvC = obj;
    }

    public int TM() {
        return this.bvD;
    }

    public void hs(int i) {
        this.bvD = i;
    }

    public static void W(List<Integer> list) {
        if (bvB.size() <= 0 && list != null) {
            for (Integer num : list) {
                bvB.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> TN() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bvB.size(); i++) {
            arrayList.add(bvB.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bvB.size() == 0 || (indexOfValue = bvB.indexOfValue(bdUniqueId)) == -1 || bvB.size() <= indexOfValue) {
            return -1;
        }
        return bvB.keyAt(indexOfValue);
    }
}
