package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dOM = new SparseArray<>();
    private Object dON;
    private int dOO;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dOM.get(this.dOO);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aTd() {
        return this.dON;
    }

    public void al(Object obj) {
        this.dON = obj;
    }

    public int aTe() {
        return this.dOO;
    }

    public void nA(int i) {
        this.dOO = i;
    }

    public static void aP(List<Integer> list) {
        if (dOM.size() <= 0 && list != null) {
            for (Integer num : list) {
                dOM.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aTf() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dOM.size(); i++) {
            arrayList.add(dOM.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dOM.size() == 0 || (indexOfValue = dOM.indexOfValue(bdUniqueId)) == -1 || dOM.size() <= indexOfValue) {
            return -1;
        }
        return dOM.keyAt(indexOfValue);
    }
}
