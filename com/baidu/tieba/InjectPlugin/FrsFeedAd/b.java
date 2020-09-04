package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fkn = new SparseArray<>();
    private Object fko;
    private int fkp;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fkn.get(this.fkp);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bzp() {
        return this.fko;
    }

    public void av(Object obj) {
        this.fko = obj;
    }

    public int bzq() {
        return this.fkp;
    }

    public void rP(int i) {
        this.fkp = i;
    }

    public static void bi(List<Integer> list) {
        if (fkn.size() <= 0 && list != null) {
            for (Integer num : list) {
                fkn.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bzr() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fkn.size(); i++) {
            arrayList.add(fkn.valueAt(i));
        }
        return arrayList;
    }

    public static int o(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fkn.size() == 0 || (indexOfValue = fkn.indexOfValue(bdUniqueId)) == -1 || fkn.size() <= indexOfValue) {
            return -1;
        }
        return fkn.keyAt(indexOfValue);
    }
}
