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
    private static SparseArray<BdUniqueId> gcn = new SparseArray<>();
    private Object gco;
    private int gcp;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gcn.get(this.gcp);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bJv() {
        return this.gco;
    }

    public void aC(Object obj) {
        this.gco = obj;
    }

    public int bJw() {
        return this.gcp;
    }

    public void sL(int i) {
        this.gcp = i;
    }

    public static void bM(List<Integer> list) {
        if (gcn.size() <= 0 && list != null) {
            for (Integer num : list) {
                gcn.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bJx() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < gcn.size(); i++) {
            arrayList.add(gcn.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (gcn.size() == 0 || (indexOfValue = gcn.indexOfValue(bdUniqueId)) == -1 || gcn.size() <= indexOfValue) {
            return -1;
        }
        return gcn.keyAt(indexOfValue);
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blH() {
        if (bJv() instanceof am) {
            return (AdvertAppInfo) bJv();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        if (bJv() instanceof am) {
            ((am) bJv()).setPosition(i);
        }
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blI() {
        if (bJv() instanceof AdvertAppInfo) {
            return ((am) bJv()).blI();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blJ() {
        return false;
    }
}
