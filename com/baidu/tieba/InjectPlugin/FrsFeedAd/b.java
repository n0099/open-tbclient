package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cHz = new SparseArray<>();
    private Object cHA;
    private int cHB;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cHz.get(this.cHB);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aud() {
        return this.cHA;
    }

    public void ah(Object obj) {
        this.cHA = obj;
    }

    public int aue() {
        return this.cHB;
    }

    public void lh(int i) {
        this.cHB = i;
    }

    public static void ak(List<Integer> list) {
        if (cHz.size() <= 0 && list != null) {
            for (Integer num : list) {
                cHz.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> auf() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cHz.size(); i++) {
            arrayList.add(cHz.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cHz.size() == 0 || (indexOfValue = cHz.indexOfValue(bdUniqueId)) == -1 || cHz.size() <= indexOfValue) {
            return -1;
        }
        return cHz.keyAt(indexOfValue);
    }
}
