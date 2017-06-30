package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h {
    private static ArrayList<h> cNz = new ArrayList<>(5);
    public int cND;
    public int cNE;
    int cNF;
    public int type;

    private void anv() {
        this.cND = 0;
        this.cNE = 0;
        this.cNF = 0;
        this.type = 0;
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long any() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cND, this.cNE) : ExpandableListView.getPackedPositionForGroup(this.cND);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h kP(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h k(int i, int i2, int i3, int i4) {
        h anz = anz();
        anz.type = i;
        anz.cND = i2;
        anz.cNE = i3;
        anz.cNF = i4;
        return anz;
    }

    private static h anz() {
        h hVar;
        synchronized (cNz) {
            if (cNz.size() > 0) {
                hVar = cNz.remove(0);
                hVar.anv();
            } else {
                hVar = new h();
            }
        }
        return hVar;
    }

    public void recycle() {
        synchronized (cNz) {
            if (cNz.size() < 5) {
                cNz.add(this);
            }
        }
    }
}
