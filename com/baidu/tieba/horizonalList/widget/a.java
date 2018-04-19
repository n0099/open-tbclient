package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> dGQ = new ArrayList<>(5);
    public int dGU;
    public int dGV;
    int dGW;
    public int type;

    private void Lz() {
        this.dGU = 0;
        this.dGV = 0;
        this.dGW = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ayr() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dGU, this.dGV) : ExpandableListView.getPackedPositionForGroup(this.dGU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a mz(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a ays = ays();
        ays.type = i;
        ays.dGU = i2;
        ays.dGV = i3;
        ays.dGW = i4;
        return ays;
    }

    private static a ays() {
        a aVar;
        synchronized (dGQ) {
            if (dGQ.size() > 0) {
                aVar = dGQ.remove(0);
                aVar.Lz();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (dGQ) {
            if (dGQ.size() < 5) {
                dGQ.add(this);
            }
        }
    }
}
