package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cRm = new ArrayList<>(5);
    public int cRq;
    public int cRr;
    int cRs;
    public int type;

    private void aqe() {
        this.cRq = 0;
        this.cRr = 0;
        this.cRs = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aqh() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cRq, this.cRr) : ExpandableListView.getPackedPositionForGroup(this.cRq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kN(int i) {
        return l(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i l(int i, int i2, int i3, int i4) {
        i aqi = aqi();
        aqi.type = i;
        aqi.cRq = i2;
        aqi.cRr = i3;
        aqi.cRs = i4;
        return aqi;
    }

    private static i aqi() {
        i iVar;
        synchronized (cRm) {
            if (cRm.size() > 0) {
                iVar = cRm.remove(0);
                iVar.aqe();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cRm) {
            if (cRm.size() < 5) {
                cRm.add(this);
            }
        }
    }
}
