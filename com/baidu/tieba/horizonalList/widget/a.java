package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eaQ = new ArrayList<>(5);
    public int eaU;
    public int eaV;
    int eaW;
    public int type;

    private void Px() {
        this.eaU = 0;
        this.eaV = 0;
        this.eaW = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aEU() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eaU, this.eaV) : ExpandableListView.getPackedPositionForGroup(this.eaU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a nf(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a r(int i, int i2, int i3, int i4) {
        a aEV = aEV();
        aEV.type = i;
        aEV.eaU = i2;
        aEV.eaV = i3;
        aEV.eaW = i4;
        return aEV;
    }

    private static a aEV() {
        a aVar;
        synchronized (eaQ) {
            if (eaQ.size() > 0) {
                aVar = eaQ.remove(0);
                aVar.Px();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eaQ) {
            if (eaQ.size() < 5) {
                eaQ.add(this);
            }
        }
    }
}
