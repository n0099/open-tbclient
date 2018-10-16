package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> epZ = new ArrayList<>(5);
    public int eqd;
    public int eqe;
    int eqf;
    public int type;

    private void Tm() {
        this.eqd = 0;
        this.eqe = 0;
        this.eqf = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aKy() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eqd, this.eqe) : ExpandableListView.getPackedPositionForGroup(this.eqd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a oh(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aKz = aKz();
        aKz.type = i;
        aKz.eqd = i2;
        aKz.eqe = i3;
        aKz.eqf = i4;
        return aKz;
    }

    private static a aKz() {
        a aVar;
        synchronized (epZ) {
            if (epZ.size() > 0) {
                aVar = epZ.remove(0);
                aVar.Tm();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (epZ) {
            if (epZ.size() < 5) {
                epZ.add(this);
            }
        }
    }
}
