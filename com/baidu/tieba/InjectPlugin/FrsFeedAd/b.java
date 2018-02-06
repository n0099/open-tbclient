package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements i, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bND = new SparseArray<>();
    private Object bNE;
    private int bNF;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bND.get(this.bNF);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Sn() {
        return this.bNE;
    }

    public void aK(Object obj) {
        this.bNE = obj;
    }

    public int So() {
        return this.bNF;
    }

    public void jb(int i) {
        this.bNF = i;
    }

    public static void T(List<Integer> list) {
        if (bND.size() <= 0 && list != null) {
            for (Integer num : list) {
                bND.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Sp() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bND.size(); i++) {
            arrayList.add(bND.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bND.size() == 0 || (indexOfValue = bND.indexOfValue(bdUniqueId)) == -1 || bND.size() <= indexOfValue) {
            return -1;
        }
        return bND.keyAt(indexOfValue);
    }
}
