package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> dbA = new SparseArray<>();
    private Object dbB;
    private int dbC;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dbA.get(this.dbC);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aAX() {
        return this.dbB;
    }

    public void af(Object obj) {
        this.dbB = obj;
    }

    public int aAY() {
        return this.dbC;
    }

    public void ln(int i) {
        this.dbC = i;
    }

    public static void aJ(List<Integer> list) {
        if (dbA.size() <= 0 && list != null) {
            for (Integer num : list) {
                dbA.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aAZ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dbA.size(); i++) {
            arrayList.add(dbA.valueAt(i));
        }
        return arrayList;
    }

    public static int k(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (dbA.size() == 0 || (indexOfValue = dbA.indexOfValue(bdUniqueId)) == -1 || dbA.size() <= indexOfValue) {
            return -1;
        }
        return dbA.keyAt(indexOfValue);
    }
}
