package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> egj = new ArrayList<>(5);
    public int egn;
    public int ego;
    int egp;
    public int type;

    private void SF() {
        this.egn = 0;
        this.ego = 0;
        this.egp = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aBP() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.egn, this.ego) : ExpandableListView.getPackedPositionForGroup(this.egn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b pg(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aBQ = aBQ();
        aBQ.type = i;
        aBQ.egn = i2;
        aBQ.ego = i3;
        aBQ.egp = i4;
        return aBQ;
    }

    private static b aBQ() {
        b bVar;
        synchronized (egj) {
            if (egj.size() > 0) {
                bVar = egj.remove(0);
                bVar.SF();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (egj) {
            if (egj.size() < 5) {
                egj.add(this);
            }
        }
    }
}
