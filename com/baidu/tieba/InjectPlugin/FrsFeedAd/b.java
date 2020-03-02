package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dST = new SparseArray<>();
    private Object dSU;
    private int dSV;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dST.get(this.dSV);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aVw() {
        return this.dSU;
    }

    public void an(Object obj) {
        this.dSU = obj;
    }

    public int aVx() {
        return this.dSV;
    }

    public void nR(int i) {
        this.dSV = i;
    }

    public static void aP(List<Integer> list) {
        if (dST.size() <= 0 && list != null) {
            for (Integer num : list) {
                dST.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aVy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dST.size(); i++) {
            arrayList.add(dST.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dST.size() == 0 || (indexOfValue = dST.indexOfValue(bdUniqueId)) == -1 || dST.size() <= indexOfValue) {
            return -1;
        }
        return dST.keyAt(indexOfValue);
    }
}
