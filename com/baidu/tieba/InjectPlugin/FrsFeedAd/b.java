package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fUT = new SparseArray<>();
    private Object fUU;
    private int fUV;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fUT.get(this.fUV);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bKv() {
        return this.fUU;
    }

    public void aA(Object obj) {
        this.fUU = obj;
    }

    public int bKw() {
        return this.fUV;
    }

    public void ua(int i) {
        this.fUV = i;
    }

    public static void bK(List<Integer> list) {
        if (fUT.size() <= 0 && list != null) {
            for (Integer num : list) {
                fUT.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bKx() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fUT.size(); i++) {
            arrayList.add(fUT.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fUT.size() == 0 || (indexOfValue = fUT.indexOfValue(bdUniqueId)) == -1 || fUT.size() <= indexOfValue) {
            return -1;
        }
        return fUT.keyAt(indexOfValue);
    }
}
