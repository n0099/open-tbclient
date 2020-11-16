package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fNi = new SparseArray<>();
    private Object fNj;
    private int fNk;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fNi.get(this.fNk);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bGV() {
        return this.fNj;
    }

    public void aA(Object obj) {
        this.fNj = obj;
    }

    public int bGW() {
        return this.fNk;
    }

    public void tx(int i) {
        this.fNk = i;
    }

    public static void bG(List<Integer> list) {
        if (fNi.size() <= 0 && list != null) {
            for (Integer num : list) {
                fNi.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bGX() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fNi.size(); i++) {
            arrayList.add(fNi.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fNi.size() == 0 || (indexOfValue = fNi.indexOfValue(bdUniqueId)) == -1 || fNi.size() <= indexOfValue) {
            return -1;
        }
        return fNi.keyAt(indexOfValue);
    }
}
