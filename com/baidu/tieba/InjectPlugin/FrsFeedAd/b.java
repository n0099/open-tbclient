package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cPJ = new SparseArray<>();
    private Object cPK;
    private int cPL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPJ.get(this.cPL);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object azi() {
        return this.cPK;
    }

    public void aj(Object obj) {
        this.cPK = obj;
    }

    public int azj() {
        return this.cPL;
    }

    public void lW(int i) {
        this.cPL = i;
    }

    public static void ar(List<Integer> list) {
        if (cPJ.size() <= 0 && list != null) {
            for (Integer num : list) {
                cPJ.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> azk() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cPJ.size(); i++) {
            arrayList.add(cPJ.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cPJ.size() == 0 || (indexOfValue = cPJ.indexOfValue(bdUniqueId)) == -1 || cPJ.size() <= indexOfValue) {
            return -1;
        }
        return cPJ.keyAt(indexOfValue);
    }
}
