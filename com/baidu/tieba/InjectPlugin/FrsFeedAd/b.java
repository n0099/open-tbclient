package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cHA = new SparseArray<>();
    private Object cHB;
    private int cHC;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cHA.get(this.cHC);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object auh() {
        return this.cHB;
    }

    public void aj(Object obj) {
        this.cHB = obj;
    }

    public int aui() {
        return this.cHC;
    }

    public void li(int i) {
        this.cHC = i;
    }

    public static void ak(List<Integer> list) {
        if (cHA.size() <= 0 && list != null) {
            for (Integer num : list) {
                cHA.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> auj() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cHA.size(); i++) {
            arrayList.add(cHA.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cHA.size() == 0 || (indexOfValue = cHA.indexOfValue(bdUniqueId)) == -1 || cHA.size() <= indexOfValue) {
            return -1;
        }
        return cHA.keyAt(indexOfValue);
    }
}
