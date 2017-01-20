package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cDx = new ArrayList<>(5);
    public int cDB;
    public int cDC;
    int cDD;
    public int type;

    private void alN() {
        this.cDB = 0;
        this.cDC = 0;
        this.cDD = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long alQ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cDB, this.cDC) : ExpandableListView.getPackedPositionForGroup(this.cDB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kK(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i alR = alR();
        alR.type = i;
        alR.cDB = i2;
        alR.cDC = i3;
        alR.cDD = i4;
        return alR;
    }

    private static i alR() {
        i iVar;
        synchronized (cDx) {
            if (cDx.size() > 0) {
                iVar = cDx.remove(0);
                iVar.alN();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cDx) {
            if (cDx.size() < 5) {
                cDx.add(this);
            }
        }
    }
}
