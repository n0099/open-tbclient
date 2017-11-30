package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dsW = new ArrayList<>(5);
    public int dta;
    public int dtb;
    int dtc;
    public int type;

    private void Lg() {
        this.dta = 0;
        this.dtb = 0;
        this.dtc = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long auD() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dta, this.dtb) : ExpandableListView.getPackedPositionForGroup(this.dta);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b mi(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(int i, int i2, int i3, int i4) {
        b auE = auE();
        auE.type = i;
        auE.dta = i2;
        auE.dtb = i3;
        auE.dtc = i4;
        return auE;
    }

    private static b auE() {
        b bVar;
        synchronized (dsW) {
            if (dsW.size() > 0) {
                bVar = dsW.remove(0);
                bVar.Lg();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dsW) {
            if (dsW.size() < 5) {
                dsW.add(this);
            }
        }
    }
}
