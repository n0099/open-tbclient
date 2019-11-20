package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> daJ = new SparseArray<>();
    private Object daK;
    private int daL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return daJ.get(this.daL);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aAV() {
        return this.daK;
    }

    public void af(Object obj) {
        this.daK = obj;
    }

    public int aAW() {
        return this.daL;
    }

    public void lm(int i) {
        this.daL = i;
    }

    public static void aJ(List<Integer> list) {
        if (daJ.size() <= 0 && list != null) {
            for (Integer num : list) {
                daJ.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aAX() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < daJ.size(); i++) {
            arrayList.add(daJ.valueAt(i));
        }
        return arrayList;
    }

    public static int k(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (daJ.size() == 0 || (indexOfValue = daJ.indexOfValue(bdUniqueId)) == -1 || daJ.size() <= indexOfValue) {
            return -1;
        }
        return daJ.keyAt(indexOfValue);
    }
}
