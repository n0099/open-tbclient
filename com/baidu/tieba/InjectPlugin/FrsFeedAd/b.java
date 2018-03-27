package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements i, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bNt = new SparseArray<>();
    private Object bNu;
    private int bNv;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bNt.get(this.bNv);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Sn() {
        return this.bNu;
    }

    public void aK(Object obj) {
        this.bNu = obj;
    }

    public int So() {
        return this.bNv;
    }

    public void jb(int i) {
        this.bNv = i;
    }

    public static void T(List<Integer> list) {
        if (bNt.size() <= 0 && list != null) {
            for (Integer num : list) {
                bNt.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Sp() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bNt.size(); i++) {
            arrayList.add(bNt.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bNt.size() == 0 || (indexOfValue = bNt.indexOfValue(bdUniqueId)) == -1 || bNt.size() <= indexOfValue) {
            return -1;
        }
        return bNt.keyAt(indexOfValue);
    }
}
