package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> cWd = new ArrayList<>(5);
    public int cWh;
    public int cWi;
    int cWj;
    public int type;

    private void wF() {
        this.cWh = 0;
        this.cWi = 0;
        this.cWj = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ape() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cWh, this.cWi) : ExpandableListView.getPackedPositionForGroup(this.cWh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b kZ(int i) {
        return m(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b m(int i, int i2, int i3, int i4) {
        b apf = apf();
        apf.type = i;
        apf.cWh = i2;
        apf.cWi = i3;
        apf.cWj = i4;
        return apf;
    }

    private static b apf() {
        b bVar;
        synchronized (cWd) {
            if (cWd.size() > 0) {
                bVar = cWd.remove(0);
                bVar.wF();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (cWd) {
            if (cWd.size() < 5) {
                cWd.add(this);
            }
        }
    }
}
