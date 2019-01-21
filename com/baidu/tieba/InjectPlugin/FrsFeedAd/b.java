package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements h, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> bwq = new SparseArray<>();
    private Object bwr;
    private int bws;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return bwq.get(this.bws);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object Uh() {
        return this.bwr;
    }

    public void P(Object obj) {
        this.bwr = obj;
    }

    public int Ui() {
        return this.bws;
    }

    public void hs(int i) {
        this.bws = i;
    }

    public static void X(List<Integer> list) {
        if (bwq.size() <= 0 && list != null) {
            for (Integer num : list) {
                bwq.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> Uj() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bwq.size(); i++) {
            arrayList.add(bwq.valueAt(i));
        }
        return arrayList;
    }

    public static int i(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (bwq.size() == 0 || (indexOfValue = bwq.indexOfValue(bdUniqueId)) == -1 || bwq.size() <= indexOfValue) {
            return -1;
        }
        return bwq.keyAt(indexOfValue);
    }
}
