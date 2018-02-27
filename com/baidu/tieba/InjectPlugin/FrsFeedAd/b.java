package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements i, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bNq = new SparseArray<>();
    private Object bNr;
    private int bNs;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bNq.get(this.bNs);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Sm() {
        return this.bNr;
    }

    public void aK(Object obj) {
        this.bNr = obj;
    }

    public int Sn() {
        return this.bNs;
    }

    public void jb(int i) {
        this.bNs = i;
    }

    public static void T(List<Integer> list) {
        if (bNq.size() <= 0 && list != null) {
            for (Integer num : list) {
                bNq.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> So() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bNq.size(); i++) {
            arrayList.add(bNq.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bNq.size() == 0 || (indexOfValue = bNq.indexOfValue(bdUniqueId)) == -1 || bNq.size() <= indexOfValue) {
            return -1;
        }
        return bNq.keyAt(indexOfValue);
    }
}
