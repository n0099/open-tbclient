package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> aXs = new SparseArray<>();
    private Object aXt;
    private int aXu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aXs.get(this.aXu);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object KJ() {
        return this.aXt;
    }

    public void F(Object obj) {
        this.aXt = obj;
    }

    public int KK() {
        return this.aXu;
    }

    public void ga(int i) {
        this.aXu = i;
    }

    public static void K(List<Integer> list) {
        if (aXs.size() <= 0 && list != null) {
            for (Integer num : list) {
                aXs.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> KL() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aXs.size(); i++) {
            arrayList.add(aXs.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (aXs.size() == 0 || (indexOfValue = aXs.indexOfValue(bdUniqueId)) == -1 || aXs.size() <= indexOfValue) {
            return -1;
        }
        return aXs.keyAt(indexOfValue);
    }
}
