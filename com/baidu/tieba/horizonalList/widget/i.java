package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cFJ = new ArrayList<>(5);
    public int cFN;
    public int cFO;
    int cFP;
    public int type;

    private void alU() {
        this.cFN = 0;
        this.cFO = 0;
        this.cFP = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long alX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cFN, this.cFO) : ExpandableListView.getPackedPositionForGroup(this.cFN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kv(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i alY = alY();
        alY.type = i;
        alY.cFN = i2;
        alY.cFO = i3;
        alY.cFP = i4;
        return alY;
    }

    private static i alY() {
        i iVar;
        synchronized (cFJ) {
            if (cFJ.size() > 0) {
                iVar = cFJ.remove(0);
                iVar.alU();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cFJ) {
            if (cFJ.size() < 5) {
                cFJ.add(this);
            }
        }
    }
}
