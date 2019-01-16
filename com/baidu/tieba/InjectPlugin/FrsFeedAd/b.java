package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bwp = new SparseArray<>();
    private Object bwq;
    private int bwr;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bwp.get(this.bwr);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Uh() {
        return this.bwq;
    }

    public void P(Object obj) {
        this.bwq = obj;
    }

    public int Ui() {
        return this.bwr;
    }

    public void hs(int i) {
        this.bwr = i;
    }

    public static void X(List<Integer> list) {
        if (bwp.size() <= 0 && list != null) {
            for (Integer num : list) {
                bwp.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Uj() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bwp.size(); i++) {
            arrayList.add(bwp.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bwp.size() == 0 || (indexOfValue = bwp.indexOfValue(bdUniqueId)) == -1 || bwp.size() <= indexOfValue) {
            return -1;
        }
        return bwp.keyAt(indexOfValue);
    }
}
