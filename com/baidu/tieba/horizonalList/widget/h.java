package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h {
    private static ArrayList<h> cFC = new ArrayList<>(5);
    public int cFG;
    public int cFH;
    int cFI;
    public int type;

    private void ajK() {
        this.cFG = 0;
        this.cFH = 0;
        this.cFI = 0;
        this.type = 0;
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ajN() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cFG, this.cFH) : ExpandableListView.getPackedPositionForGroup(this.cFG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h kE(int i) {
        return i(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h i(int i, int i2, int i3, int i4) {
        h ajO = ajO();
        ajO.type = i;
        ajO.cFG = i2;
        ajO.cFH = i3;
        ajO.cFI = i4;
        return ajO;
    }

    private static h ajO() {
        h hVar;
        synchronized (cFC) {
            if (cFC.size() > 0) {
                hVar = cFC.remove(0);
                hVar.ajK();
            } else {
                hVar = new h();
            }
        }
        return hVar;
    }

    public void recycle() {
        synchronized (cFC) {
            if (cFC.size() < 5) {
                cFC.add(this);
            }
        }
    }
}
