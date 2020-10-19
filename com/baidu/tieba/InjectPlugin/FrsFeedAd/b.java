package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b implements q, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> fzu = new SparseArray<>();
    private Object fzv;
    private int fzw;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fzu.get(this.fzw);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bDk() {
        return this.fzv;
    }

    public void aA(Object obj) {
        this.fzv = obj;
    }

    public int bDl() {
        return this.fzw;
    }

    public void sE(int i) {
        this.fzw = i;
    }

    public static void bq(List<Integer> list) {
        if (fzu.size() <= 0 && list != null) {
            for (Integer num : list) {
                fzu.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bDm() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fzu.size(); i++) {
            arrayList.add(fzu.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (fzu.size() == 0 || (indexOfValue = fzu.indexOfValue(bdUniqueId)) == -1 || fzu.size() <= indexOfValue) {
            return -1;
        }
        return fzu.keyAt(indexOfValue);
    }
}
