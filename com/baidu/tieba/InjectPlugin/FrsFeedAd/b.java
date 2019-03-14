package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements m, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> cHx = new SparseArray<>();
    private Object cHy;
    private int cHz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cHx.get(this.cHz);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object aug() {
        return this.cHy;
    }

    public void aj(Object obj) {
        this.cHy = obj;
    }

    public int auh() {
        return this.cHz;
    }

    public void li(int i) {
        this.cHz = i;
    }

    public static void ak(List<Integer> list) {
        if (cHx.size() <= 0 && list != null) {
            for (Integer num : list) {
                cHx.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> aui() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cHx.size(); i++) {
            arrayList.add(cHx.valueAt(i));
        }
        return arrayList;
    }

    public static int j(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (cHx.size() == 0 || (indexOfValue = cHx.indexOfValue(bdUniqueId)) == -1 || cHx.size() <= indexOfValue) {
            return -1;
        }
        return cHx.keyAt(indexOfValue);
    }
}
