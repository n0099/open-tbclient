package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements o, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> eIk = new SparseArray<>();
    private Object eIl;
    private int eIm;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return eIk.get(this.eIm);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bjW() {
        return this.eIl;
    }

    public void as(Object obj) {
        this.eIl = obj;
    }

    public int bjX() {
        return this.eIm;
    }

    public void oN(int i) {
        this.eIm = i;
    }

    public static void aU(List<Integer> list) {
        if (eIk.size() <= 0 && list != null) {
            for (Integer num : list) {
                eIk.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bjY() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eIk.size(); i++) {
            arrayList.add(eIk.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (eIk.size() == 0 || (indexOfValue = eIk.indexOfValue(bdUniqueId)) == -1 || eIk.size() <= indexOfValue) {
            return -1;
        }
        return eIk.keyAt(indexOfValue);
    }
}
