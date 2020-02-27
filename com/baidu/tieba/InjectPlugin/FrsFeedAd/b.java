package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dSS = new SparseArray<>();
    private Object dST;
    private int dSU;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dSS.get(this.dSU);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aVu() {
        return this.dST;
    }

    public void an(Object obj) {
        this.dST = obj;
    }

    public int aVv() {
        return this.dSU;
    }

    public void nR(int i) {
        this.dSU = i;
    }

    public static void aP(List<Integer> list) {
        if (dSS.size() <= 0 && list != null) {
            for (Integer num : list) {
                dSS.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aVw() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dSS.size(); i++) {
            arrayList.add(dSS.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dSS.size() == 0 || (indexOfValue = dSS.indexOfValue(bdUniqueId)) == -1 || dSS.size() <= indexOfValue) {
            return -1;
        }
        return dSS.keyAt(indexOfValue);
    }
}
