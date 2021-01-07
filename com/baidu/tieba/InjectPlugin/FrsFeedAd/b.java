package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements n, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> gez = new SparseArray<>();
    private Object geA;
    private int geB;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gez.get(this.geB);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bMO() {
        return this.geA;
    }

    public void aC(Object obj) {
        this.geA = obj;
    }

    public int bMP() {
        return this.geB;
    }

    public void um(int i) {
        this.geB = i;
    }

    public static void bR(List<Integer> list) {
        if (gez.size() <= 0 && list != null) {
            for (Integer num : list) {
                gez.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bMQ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < gez.size(); i++) {
            arrayList.add(gez.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (gez.size() == 0 || (indexOfValue = gez.indexOfValue(bdUniqueId)) == -1 || gez.size() <= indexOfValue) {
            return -1;
        }
        return gez.keyAt(indexOfValue);
    }
}
