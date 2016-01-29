package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> bHN = new ArrayList<>(5);
    public int bHR;
    public int bHS;
    int bHT;
    public int type;

    private void Xd() {
        this.bHR = 0;
        this.bHS = 0;
        this.bHT = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Xf() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bHR, this.bHS) : ExpandableListView.getPackedPositionForGroup(this.bHR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i ii(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i j(int i, int i2, int i3, int i4) {
        i Xg = Xg();
        Xg.type = i;
        Xg.bHR = i2;
        Xg.bHS = i3;
        Xg.bHT = i4;
        return Xg;
    }

    private static i Xg() {
        i iVar;
        synchronized (bHN) {
            if (bHN.size() > 0) {
                iVar = bHN.remove(0);
                iVar.Xd();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (bHN) {
            if (bHN.size() < 5) {
                bHN.add(this);
            }
        }
    }
}
