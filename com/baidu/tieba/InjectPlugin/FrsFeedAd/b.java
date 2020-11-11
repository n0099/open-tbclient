package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fNF = new SparseArray<>();
    private Object fNG;
    private int fNH;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fNF.get(this.fNH);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bHC() {
        return this.fNG;
    }

    public void aA(Object obj) {
        this.fNG = obj;
    }

    public int bHD() {
        return this.fNH;
    }

    public void sZ(int i) {
        this.fNH = i;
    }

    public static void bG(List<Integer> list) {
        if (fNF.size() <= 0 && list != null) {
            for (Integer num : list) {
                fNF.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bHE() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fNF.size(); i++) {
            arrayList.add(fNF.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fNF.size() == 0 || (indexOfValue = fNF.indexOfValue(bdUniqueId)) == -1 || fNF.size() <= indexOfValue) {
            return -1;
        }
        return fNF.keyAt(indexOfValue);
    }
}
