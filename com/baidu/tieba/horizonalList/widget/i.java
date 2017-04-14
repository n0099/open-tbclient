package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cDs = new ArrayList<>(5);
    public int cDw;
    public int cDx;
    int cDy;
    public int type;

    private void akT() {
        this.cDw = 0;
        this.cDx = 0;
        this.cDy = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long akW() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cDw, this.cDx) : ExpandableListView.getPackedPositionForGroup(this.cDw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kp(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i akX = akX();
        akX.type = i;
        akX.cDw = i2;
        akX.cDx = i3;
        akX.cDy = i4;
        return akX;
    }

    private static i akX() {
        i iVar;
        synchronized (cDs) {
            if (cDs.size() > 0) {
                iVar = cDs.remove(0);
                iVar.akT();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cDs) {
            if (cDs.size() < 5) {
                cDs.add(this);
            }
        }
    }
}
