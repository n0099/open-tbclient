package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bgN = new SparseArray<>();
    private Object bgO;
    private int bgP;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bgN.get(this.bgP);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object OB() {
        return this.bgO;
    }

    public void I(Object obj) {
        this.bgO = obj;
    }

    public int OC() {
        return this.bgP;
    }

    public void gc(int i) {
        this.bgP = i;
    }

    public static void O(List<Integer> list) {
        if (bgN.size() <= 0 && list != null) {
            for (Integer num : list) {
                bgN.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> OD() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bgN.size(); i++) {
            arrayList.add(bgN.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bgN.size() == 0 || (indexOfValue = bgN.indexOfValue(bdUniqueId)) == -1 || bgN.size() <= indexOfValue) {
            return -1;
        }
        return bgN.keyAt(indexOfValue);
    }
}
