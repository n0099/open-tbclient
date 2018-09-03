package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bht = new SparseArray<>();
    private Object bhu;
    private int bhv;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bht.get(this.bhv);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object OG() {
        return this.bhu;
    }

    public void I(Object obj) {
        this.bhu = obj;
    }

    public int OH() {
        return this.bhv;
    }

    public void gg(int i) {
        this.bhv = i;
    }

    public static void N(List<Integer> list) {
        if (bht.size() <= 0 && list != null) {
            for (Integer num : list) {
                bht.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> OI() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bht.size(); i++) {
            arrayList.add(bht.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bht.size() == 0 || (indexOfValue = bht.indexOfValue(bdUniqueId)) == -1 || bht.size() <= indexOfValue) {
            return -1;
        }
        return bht.keyAt(indexOfValue);
    }
}
