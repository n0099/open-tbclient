package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cwt = new ArrayList<>(5);
    public int cwx;
    public int cwy;
    int cwz;
    public int type;

    private void akG() {
        this.cwx = 0;
        this.cwy = 0;
        this.cwz = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long akJ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cwx, this.cwy) : ExpandableListView.getPackedPositionForGroup(this.cwx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i jX(int i) {
        return l(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i l(int i, int i2, int i3, int i4) {
        i akK = akK();
        akK.type = i;
        akK.cwx = i2;
        akK.cwy = i3;
        akK.cwz = i4;
        return akK;
    }

    private static i akK() {
        i iVar;
        synchronized (cwt) {
            if (cwt.size() > 0) {
                iVar = cwt.remove(0);
                iVar.akG();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cwt) {
            if (cwt.size() < 5) {
                cwt.add(this);
            }
        }
    }
}
