package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dTg = new SparseArray<>();
    private Object dTh;
    private int dTi;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dTg.get(this.dTi);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aVx() {
        return this.dTh;
    }

    public void an(Object obj) {
        this.dTh = obj;
    }

    public int aVy() {
        return this.dTi;
    }

    public void nR(int i) {
        this.dTi = i;
    }

    public static void aP(List<Integer> list) {
        if (dTg.size() <= 0 && list != null) {
            for (Integer num : list) {
                dTg.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aVz() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dTg.size(); i++) {
            arrayList.add(dTg.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dTg.size() == 0 || (indexOfValue = dTg.indexOfValue(bdUniqueId)) == -1 || dTg.size() <= indexOfValue) {
            return -1;
        }
        return dTg.keyAt(indexOfValue);
    }
}
