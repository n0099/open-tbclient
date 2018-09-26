package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bnl = new SparseArray<>();
    private Object bnm;
    private int bnn;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bnl.get(this.bnn);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object QA() {
        return this.bnm;
    }

    public void L(Object obj) {
        this.bnm = obj;
    }

    public int QB() {
        return this.bnn;
    }

    public void gH(int i) {
        this.bnn = i;
    }

    public static void O(List<Integer> list) {
        if (bnl.size() <= 0 && list != null) {
            for (Integer num : list) {
                bnl.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> QC() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bnl.size(); i++) {
            arrayList.add(bnl.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bnl.size() == 0 || (indexOfValue = bnl.indexOfValue(bdUniqueId)) == -1 || bnl.size() <= indexOfValue) {
            return -1;
        }
        return bnl.keyAt(indexOfValue);
    }
}
