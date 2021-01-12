package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements n, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fZP = new SparseArray<>();
    private Object fZQ;
    private int fZR;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return fZP.get(this.fZR);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bIW() {
        return this.fZQ;
    }

    public void aC(Object obj) {
        this.fZQ = obj;
    }

    public int bIX() {
        return this.fZR;
    }

    public void sG(int i) {
        this.fZR = i;
    }

    public static void bR(List<Integer> list) {
        if (fZP.size() <= 0 && list != null) {
            for (Integer num : list) {
                fZP.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bIY() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fZP.size(); i++) {
            arrayList.add(fZP.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fZP.size() == 0 || (indexOfValue = fZP.indexOfValue(bdUniqueId)) == -1 || fZP.size() <= indexOfValue) {
            return -1;
        }
        return fZP.keyAt(indexOfValue);
    }
}
