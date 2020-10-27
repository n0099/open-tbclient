package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fHP = new SparseArray<>();
    private Object fHQ;
    private int fHR;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fHP.get(this.fHR);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bFd() {
        return this.fHQ;
    }

    public void aA(Object obj) {
        this.fHQ = obj;
    }

    public int bFe() {
        return this.fHR;
    }

    public void sP(int i) {
        this.fHR = i;
    }

    public static void bz(List<Integer> list) {
        if (fHP.size() <= 0 && list != null) {
            for (Integer num : list) {
                fHP.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bFf() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fHP.size(); i++) {
            arrayList.add(fHP.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fHP.size() == 0 || (indexOfValue = fHP.indexOfValue(bdUniqueId)) == -1 || fHP.size() <= indexOfValue) {
            return -1;
        }
        return fHP.keyAt(indexOfValue);
    }
}
