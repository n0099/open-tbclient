package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> eSw = new SparseArray<>();
    private Object eSx;
    private int eSy;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eSw.get(this.eSy);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bmv() {
        return this.eSx;
    }

    public void at(Object obj) {
        this.eSx = obj;
    }

    public int bmw() {
        return this.eSy;
    }

    public void pl(int i) {
        this.eSy = i;
    }

    public static void be(List<Integer> list) {
        if (eSw.size() <= 0 && list != null) {
            for (Integer num : list) {
                eSw.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bmx() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eSw.size(); i++) {
            arrayList.add(eSw.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (eSw.size() == 0 || (indexOfValue = eSw.indexOfValue(bdUniqueId)) == -1 || eSw.size() <= indexOfValue) {
            return -1;
        }
        return eSw.keyAt(indexOfValue);
    }
}
