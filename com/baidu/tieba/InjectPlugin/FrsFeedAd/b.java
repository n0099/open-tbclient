package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cRn = new SparseArray<>();
    private Object cRo;
    private int cRp;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cRn.get(this.cRp);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aAz() {
        return this.cRo;
    }

    public void aj(Object obj) {
        this.cRo = obj;
    }

    public int aAA() {
        return this.cRp;
    }

    public void me(int i) {
        this.cRp = i;
    }

    public static void ar(List<Integer> list) {
        if (cRn.size() <= 0 && list != null) {
            for (Integer num : list) {
                cRn.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aAB() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cRn.size(); i++) {
            arrayList.add(cRn.valueAt(i));
        }
        return arrayList;
    }

    public static int k(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cRn.size() == 0 || (indexOfValue = cRn.indexOfValue(bdUniqueId)) == -1 || cRn.size() <= indexOfValue) {
            return -1;
        }
        return cRn.keyAt(indexOfValue);
    }
}
