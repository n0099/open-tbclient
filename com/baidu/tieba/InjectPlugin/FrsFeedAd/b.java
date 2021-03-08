package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements n, am, com.baidu.tieba.InjectPlugin.a {
    private static SparseArray<BdUniqueId> gdO = new SparseArray<>();
    private Object gdP;
    private int gdQ;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gdO.get(this.gdQ);
    }

    @Override // com.baidu.tieba.InjectPlugin.a
    public Object bJz() {
        return this.gdP;
    }

    public void aE(Object obj) {
        this.gdP = obj;
    }

    public int bJA() {
        return this.gdQ;
    }

    public void sN(int i) {
        this.gdQ = i;
    }

    public static void bM(List<Integer> list) {
        if (gdO.size() <= 0 && list != null) {
            for (Integer num : list) {
                gdO.put(num.intValue(), BdUniqueId.gen());
            }
        }
    }

    public static List<BdUniqueId> bJB() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < gdO.size(); i++) {
            arrayList.add(gdO.valueAt(i));
        }
        return arrayList;
    }

    public static int n(BdUniqueId bdUniqueId) {
        int indexOfValue;
        if (gdO.size() == 0 || (indexOfValue = gdO.indexOfValue(bdUniqueId)) == -1 || gdO.size() <= indexOfValue) {
            return -1;
        }
        return gdO.keyAt(indexOfValue);
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blJ() {
        if (bJz() instanceof am) {
            return (AdvertAppInfo) bJz();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        if (bJz() instanceof am) {
            ((am) bJz()).setPosition(i);
        }
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blK() {
        if (bJz() instanceof AdvertAppInfo) {
            return ((am) bJz()).blK();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blL() {
        return false;
    }
}
