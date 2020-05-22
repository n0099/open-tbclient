package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements o, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> eHZ = new SparseArray<>();
    private Object eIa;
    private int eIb;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return eHZ.get(this.eIb);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bjU() {
        return this.eIa;
    }

    public void as(Object obj) {
        this.eIa = obj;
    }

    public int bjV() {
        return this.eIb;
    }

    public void oL(int i) {
        this.eIb = i;
    }

    public static void aU(List<Integer> list) {
        if (eHZ.size() <= 0 && list != null) {
            for (Integer num : list) {
                eHZ.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bjW() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eHZ.size(); i++) {
            arrayList.add(eHZ.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (eHZ.size() == 0 || (indexOfValue = eHZ.indexOfValue(bdUniqueId)) == -1 || eHZ.size() <= indexOfValue) {
            return -1;
        }
        return eHZ.keyAt(indexOfValue);
    }
}
