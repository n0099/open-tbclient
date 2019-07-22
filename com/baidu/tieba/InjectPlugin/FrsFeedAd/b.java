package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cRg = new SparseArray<>();
    private Object cRh;
    private int cRi;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cRg.get(this.cRi);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aAx() {
        return this.cRh;
    }

    public void aj(Object obj) {
        this.cRh = obj;
    }

    public int aAy() {
        return this.cRi;
    }

    public void md(int i) {
        this.cRi = i;
    }

    public static void ar(List<Integer> list) {
        if (cRg.size() <= 0 && list != null) {
            for (Integer num : list) {
                cRg.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aAz() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cRg.size(); i++) {
            arrayList.add(cRg.valueAt(i));
        }
        return arrayList;
    }

    public static int k(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cRg.size() == 0 || (indexOfValue = cRg.indexOfValue(bdUniqueId)) == -1 || cRg.size() <= indexOfValue) {
            return -1;
        }
        return cRg.keyAt(indexOfValue);
    }
}
