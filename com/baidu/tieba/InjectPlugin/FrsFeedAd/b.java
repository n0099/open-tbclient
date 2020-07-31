package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> eYR = new SparseArray<>();
    private Object eYS;
    private int eYT;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eYR.get(this.eYT);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bqq() {
        return this.eYS;
    }

    public void at(Object obj) {
        this.eYS = obj;
    }

    public int bqr() {
        return this.eYT;
    }

    public void pD(int i) {
        this.eYT = i;
    }

    public static void bi(List<Integer> list) {
        if (eYR.size() <= 0 && list != null) {
            for (Integer num : list) {
                eYR.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bqs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eYR.size(); i++) {
            arrayList.add(eYR.valueAt(i));
        }
        return arrayList;
    }

    public static int o(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (eYR.size() == 0 || (indexOfValue = eYR.indexOfValue(bdUniqueId)) == -1 || eYR.size() <= indexOfValue) {
            return -1;
        }
        return eYR.keyAt(indexOfValue);
    }
}
