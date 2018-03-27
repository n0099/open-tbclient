package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> emn = new ArrayList<>(5);
    public int emr;
    public int ems;
    int emt;
    public int type;

    private void Tc() {
        this.emr = 0;
        this.ems = 0;
        this.emt = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDt() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.emr, this.ems) : ExpandableListView.getPackedPositionForGroup(this.emr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b pb(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aDu = aDu();
        aDu.type = i;
        aDu.emr = i2;
        aDu.ems = i3;
        aDu.emt = i4;
        return aDu;
    }

    private static b aDu() {
        b bVar;
        synchronized (emn) {
            if (emn.size() > 0) {
                bVar = emn.remove(0);
                bVar.Tc();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (emn) {
            if (emn.size() < 5) {
                emn.add(this);
            }
        }
    }
}
