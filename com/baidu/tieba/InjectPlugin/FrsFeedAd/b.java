package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fng = new SparseArray<>();
    private Object fnh;
    private int fni;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fng.get(this.fni);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bAy() {
        return this.fnh;
    }

    public void ax(Object obj) {
        this.fnh = obj;
    }

    public int bAz() {
        return this.fni;
    }

    public void sg(int i) {
        this.fni = i;
    }

    public static void bn(List<Integer> list) {
        if (fng.size() <= 0 && list != null) {
            for (Integer num : list) {
                fng.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bAA() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fng.size(); i++) {
            arrayList.add(fng.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fng.size() == 0 || (indexOfValue = fng.indexOfValue(bdUniqueId)) == -1 || fng.size() <= indexOfValue) {
            return -1;
        }
        return fng.keyAt(indexOfValue);
    }
}
