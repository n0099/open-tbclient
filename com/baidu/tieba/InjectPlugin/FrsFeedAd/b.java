package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fkj = new SparseArray<>();
    private Object fkk;
    private int fkl;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fkj.get(this.fkl);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bzo() {
        return this.fkk;
    }

    public void av(Object obj) {
        this.fkk = obj;
    }

    public int bzp() {
        return this.fkl;
    }

    public void rP(int i) {
        this.fkl = i;
    }

    public static void bi(List<Integer> list) {
        if (fkj.size() <= 0 && list != null) {
            for (Integer num : list) {
                fkj.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bzq() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fkj.size(); i++) {
            arrayList.add(fkj.valueAt(i));
        }
        return arrayList;
    }

    public static int o(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fkj.size() == 0 || (indexOfValue = fkj.indexOfValue(bdUniqueId)) == -1 || fkj.size() <= indexOfValue) {
            return -1;
        }
        return fkj.keyAt(indexOfValue);
    }
}
