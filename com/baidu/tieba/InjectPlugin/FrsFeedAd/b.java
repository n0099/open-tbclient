package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements n, am, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> gci = new SparseArray<>();
    private Object gcj;
    private int gck;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gci.get(this.gck);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bJq() {
        return this.gcj;
    }

    public void aC(Object obj) {
        this.gcj = obj;
    }

    public int bJr() {
        return this.gck;
    }

    public void sL(int i) {
        this.gck = i;
    }

    public static void bM(List<Integer> list) {
        if (gci.size() <= 0 && list != null) {
            for (Integer num : list) {
                gci.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bJs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < gci.size(); i++) {
            arrayList.add(gci.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (gci.size() == 0 || (indexOfValue = gci.indexOfValue(bdUniqueId)) == -1 || gci.size() <= indexOfValue) {
            return -1;
        }
        return gci.keyAt(indexOfValue);
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blH() {
        if (bJq() instanceof am) {
            return (AdvertAppInfo) bJq();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        if (bJq() instanceof am) {
            ((am) bJq()).setPosition(i);
        }
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blI() {
        if (bJq() instanceof AdvertAppInfo) {
            return ((am) bJq()).blI();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blJ() {
        return false;
    }
}
