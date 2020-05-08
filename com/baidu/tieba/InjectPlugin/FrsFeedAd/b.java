package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> etA = new SparseArray<>();
    private Object etB;
    private int etC;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return etA.get(this.etC);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bdJ() {
        return this.etB;
    }

    public void ao(Object obj) {
        this.etB = obj;
    }

    public int bdK() {
        return this.etC;
    }

    public void og(int i) {
        this.etC = i;
    }

    public static void aZ(List<Integer> list) {
        if (etA.size() <= 0 && list != null) {
            for (Integer num : list) {
                etA.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bdL() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < etA.size(); i++) {
            arrayList.add(etA.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (etA.size() == 0 || (indexOfValue = etA.indexOfValue(bdUniqueId)) == -1 || etA.size() <= indexOfValue) {
            return -1;
        }
        return etA.keyAt(indexOfValue);
    }
}
