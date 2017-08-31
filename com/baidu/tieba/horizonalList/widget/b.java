package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dgd = new ArrayList<>(5);
    public int dgh;
    public int dgi;
    int dgj;
    public int type;

    private void wN() {
        this.dgh = 0;
        this.dgi = 0;
        this.dgj = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long arB() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dgh, this.dgi) : ExpandableListView.getPackedPositionForGroup(this.dgh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lA(int i) {
        return m(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b m(int i, int i2, int i3, int i4) {
        b arC = arC();
        arC.type = i;
        arC.dgh = i2;
        arC.dgi = i3;
        arC.dgj = i4;
        return arC;
    }

    private static b arC() {
        b bVar;
        synchronized (dgd) {
            if (dgd.size() > 0) {
                bVar = dgd.remove(0);
                bVar.wN();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dgd) {
            if (dgd.size() < 5) {
                dgd.add(this);
            }
        }
    }
}
