package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dOE = new SparseArray<>();
    private Object dOF;
    private int dOG;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dOE.get(this.dOG);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aSJ() {
        return this.dOF;
    }

    public void al(Object obj) {
        this.dOF = obj;
    }

    public int aSK() {
        return this.dOG;
    }

    public void nA(int i) {
        this.dOG = i;
    }

    public static void aQ(List<Integer> list) {
        if (dOE.size() <= 0 && list != null) {
            for (Integer num : list) {
                dOE.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aSL() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dOE.size(); i++) {
            arrayList.add(dOE.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dOE.size() == 0 || (indexOfValue = dOE.indexOfValue(bdUniqueId)) == -1 || dOE.size() <= indexOfValue) {
            return -1;
        }
        return dOE.keyAt(indexOfValue);
    }
}
