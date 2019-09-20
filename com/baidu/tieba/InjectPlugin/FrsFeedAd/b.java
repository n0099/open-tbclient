package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cSg = new SparseArray<>();
    private Object cSh;
    private int cSi;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cSg.get(this.cSi);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aAN() {
        return this.cSh;
    }

    public void aj(Object obj) {
        this.cSh = obj;
    }

    public int aAO() {
        return this.cSi;
    }

    public void mi(int i) {
        this.cSi = i;
    }

    public static void ar(List<Integer> list) {
        if (cSg.size() <= 0 && list != null) {
            for (Integer num : list) {
                cSg.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aAP() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cSg.size(); i++) {
            arrayList.add(cSg.valueAt(i));
        }
        return arrayList;
    }

    public static int k(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cSg.size() == 0 || (indexOfValue = cSg.indexOfValue(bdUniqueId)) == -1 || cSg.size() <= indexOfValue) {
            return -1;
        }
        return cSg.keyAt(indexOfValue);
    }
}
