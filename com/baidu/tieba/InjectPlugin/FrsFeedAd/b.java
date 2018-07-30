package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bhs = new SparseArray<>();
    private Object bht;
    private int bhu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bhs.get(this.bhu);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object OH() {
        return this.bht;
    }

    public void I(Object obj) {
        this.bht = obj;
    }

    public int OI() {
        return this.bhu;
    }

    public void gh(int i) {
        this.bhu = i;
    }

    public static void N(List<Integer> list) {
        if (bhs.size() <= 0 && list != null) {
            for (Integer num : list) {
                bhs.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> OJ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bhs.size(); i++) {
            arrayList.add(bhs.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bhs.size() == 0 || (indexOfValue = bhs.indexOfValue(bdUniqueId)) == -1 || bhs.size() <= indexOfValue) {
            return -1;
        }
        return bhs.keyAt(indexOfValue);
    }
}
