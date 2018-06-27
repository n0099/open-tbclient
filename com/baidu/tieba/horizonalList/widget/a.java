package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> dWY = new ArrayList<>(5);
    public int dXc;
    public int dXd;
    int dXe;
    public int type;

    private void Pr() {
        this.dXc = 0;
        this.dXd = 0;
        this.dXe = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDU() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dXc, this.dXd) : ExpandableListView.getPackedPositionForGroup(this.dXc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a mR(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aDV = aDV();
        aDV.type = i;
        aDV.dXc = i2;
        aDV.dXd = i3;
        aDV.dXe = i4;
        return aDV;
    }

    private static a aDV() {
        a aVar;
        synchronized (dWY) {
            if (dWY.size() > 0) {
                aVar = dWY.remove(0);
                aVar.Pr();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (dWY) {
            if (dWY.size() < 5) {
                dWY.add(this);
            }
        }
    }
}
