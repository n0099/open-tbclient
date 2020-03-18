package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dTw = new SparseArray<>();
    private Object dTx;
    private int dTy;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dTw.get(this.dTy);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aVB() {
        return this.dTx;
    }

    public void an(Object obj) {
        this.dTx = obj;
    }

    public int aVC() {
        return this.dTy;
    }

    public void nT(int i) {
        this.dTy = i;
    }

    public static void aP(List<Integer> list) {
        if (dTw.size() <= 0 && list != null) {
            for (Integer num : list) {
                dTw.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aVD() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dTw.size(); i++) {
            arrayList.add(dTw.valueAt(i));
        }
        return arrayList;
    }

    public static int l(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dTw.size() == 0 || (indexOfValue = dTw.indexOfValue(bdUniqueId)) == -1 || dTw.size() <= indexOfValue) {
            return -1;
        }
        return dTw.keyAt(indexOfValue);
    }
}
