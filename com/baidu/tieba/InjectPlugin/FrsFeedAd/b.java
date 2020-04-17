package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> etv = new SparseArray<>();
    private Object etw;
    private int etx;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return etv.get(this.etx);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bdL() {
        return this.etw;
    }

    public void an(Object obj) {
        this.etw = obj;
    }

    public int bdM() {
        return this.etx;
    }

    public void og(int i) {
        this.etx = i;
    }

    public static void aZ(List<Integer> list) {
        if (etv.size() <= 0 && list != null) {
            for (Integer num : list) {
                etv.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bdN() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < etv.size(); i++) {
            arrayList.add(etv.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (etv.size() == 0 || (indexOfValue = etv.indexOfValue(bdUniqueId)) == -1 || etv.size() <= indexOfValue) {
            return -1;
        }
        return etv.keyAt(indexOfValue);
    }
}
