package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> brn = new SparseArray<>();
    private Object bro;
    private int brp;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return brn.get(this.brp);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Su() {
        return this.bro;
    }

    public void P(Object obj) {
        this.bro = obj;
    }

    public int Sv() {
        return this.brp;
    }

    public void gP(int i) {
        this.brp = i;
    }

    public static void X(List<Integer> list) {
        if (brn.size() <= 0 && list != null) {
            for (Integer num : list) {
                brn.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Sw() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < brn.size(); i++) {
            arrayList.add(brn.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (brn.size() == 0 || (indexOfValue = brn.indexOfValue(bdUniqueId)) == -1 || brn.size() <= indexOfValue) {
            return -1;
        }
        return brn.keyAt(indexOfValue);
    }
}
