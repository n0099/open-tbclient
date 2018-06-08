package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bfz = new SparseArray<>();
    private Object bfA;
    private int bfB;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bfz.get(this.bfB);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Oi() {
        return this.bfA;
    }

    public void I(Object obj) {
        this.bfA = obj;
    }

    public int Oj() {
        return this.bfB;
    }

    public void gb(int i) {
        this.bfB = i;
    }

    public static void N(List<Integer> list) {
        if (bfz.size() <= 0 && list != null) {
            for (Integer num : list) {
                bfz.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Ok() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bfz.size(); i++) {
            arrayList.add(bfz.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bfz.size() == 0 || (indexOfValue = bfz.indexOfValue(bdUniqueId)) == -1 || bfz.size() <= indexOfValue) {
            return -1;
        }
        return bfz.keyAt(indexOfValue);
    }
}
