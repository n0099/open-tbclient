package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> ehE = new ArrayList<>(5);
    public int ehI;
    public int ehJ;
    int ehK;
    public int type;

    private void St() {
        this.ehI = 0;
        this.ehJ = 0;
        this.ehK = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aBU() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.ehI, this.ehJ) : ExpandableListView.getPackedPositionForGroup(this.ehI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b oZ(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aBV = aBV();
        aBV.type = i;
        aBV.ehI = i2;
        aBV.ehJ = i3;
        aBV.ehK = i4;
        return aBV;
    }

    private static b aBV() {
        b bVar;
        synchronized (ehE) {
            if (ehE.size() > 0) {
                bVar = ehE.remove(0);
                bVar.St();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (ehE) {
            if (ehE.size() < 5) {
                ehE.add(this);
            }
        }
    }
}
