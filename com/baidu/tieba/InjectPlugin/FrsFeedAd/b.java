package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> aXr = new SparseArray<>();
    private Object aXs;
    private int aXt;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aXr.get(this.aXt);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object KL() {
        return this.aXs;
    }

    public void F(Object obj) {
        this.aXs = obj;
    }

    public int KM() {
        return this.aXt;
    }

    public void fZ(int i) {
        this.aXt = i;
    }

    public static void K(List<Integer> list) {
        if (aXr.size() <= 0 && list != null) {
            for (Integer num : list) {
                aXr.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> KN() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aXr.size(); i++) {
            arrayList.add(aXr.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (aXr.size() == 0 || (indexOfValue = aXr.indexOfValue(bdUniqueId)) == -1 || aXr.size() <= indexOfValue) {
            return -1;
        }
        return aXr.keyAt(indexOfValue);
    }
}
