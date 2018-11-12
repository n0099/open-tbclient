package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> brZ = new SparseArray<>();
    private Object bsa;
    private int bsb;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return brZ.get(this.bsb);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object SD() {
        return this.bsa;
    }

    public void P(Object obj) {
        this.bsa = obj;
    }

    public int SE() {
        return this.bsb;
    }

    public void hd(int i) {
        this.bsb = i;
    }

    public static void W(List<Integer> list) {
        if (brZ.size() <= 0 && list != null) {
            for (Integer num : list) {
                brZ.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> SF() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < brZ.size(); i++) {
            arrayList.add(brZ.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (brZ.size() == 0 || (indexOfValue = brZ.indexOfValue(bdUniqueId)) == -1 || brZ.size() <= indexOfValue) {
            return -1;
        }
        return brZ.keyAt(indexOfValue);
    }
}
