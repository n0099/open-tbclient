package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cPK = new SparseArray<>();
    private Object cPL;
    private int cPM;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPK.get(this.cPM);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object azj() {
        return this.cPL;
    }

    public void aj(Object obj) {
        this.cPL = obj;
    }

    public int azk() {
        return this.cPM;
    }

    public void lW(int i) {
        this.cPM = i;
    }

    public static void ar(List<Integer> list) {
        if (cPK.size() <= 0 && list != null) {
            for (Integer num : list) {
                cPK.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> azl() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cPK.size(); i++) {
            arrayList.add(cPK.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cPK.size() == 0 || (indexOfValue = cPK.indexOfValue(bdUniqueId)) == -1 || cPK.size() <= indexOfValue) {
            return -1;
        }
        return cPK.keyAt(indexOfValue);
    }
}
