package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dgY = new ArrayList<>(5);
    public int dhc;
    public int dhd;
    int dhe;
    public int type;

    private void wN() {
        this.dhc = 0;
        this.dhd = 0;
        this.dhe = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long arM() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dhc, this.dhd) : ExpandableListView.getPackedPositionForGroup(this.dhc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lC(int i) {
        return m(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b m(int i, int i2, int i3, int i4) {
        b arN = arN();
        arN.type = i;
        arN.dhc = i2;
        arN.dhd = i3;
        arN.dhe = i4;
        return arN;
    }

    private static b arN() {
        b bVar;
        synchronized (dgY) {
            if (dgY.size() > 0) {
                bVar = dgY.remove(0);
                bVar.wN();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dgY) {
            if (dgY.size() < 5) {
                dgY.add(this);
            }
        }
    }
}
