package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bvy = new SparseArray<>();
    private int bvA;
    private Object bvz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bvy.get(this.bvA);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object TJ() {
        return this.bvz;
    }

    public void P(Object obj) {
        this.bvz = obj;
    }

    public int TK() {
        return this.bvA;
    }

    public void hr(int i) {
        this.bvA = i;
    }

    public static void W(List<Integer> list) {
        if (bvy.size() <= 0 && list != null) {
            for (Integer num : list) {
                bvy.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> TL() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bvy.size(); i++) {
            arrayList.add(bvy.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bvy.size() == 0 || (indexOfValue = bvy.indexOfValue(bdUniqueId)) == -1 || bvy.size() <= indexOfValue) {
            return -1;
        }
        return bvy.keyAt(indexOfValue);
    }
}
