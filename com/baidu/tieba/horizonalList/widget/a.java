package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class a {
    private static ArrayList<a> bmc = new ArrayList<>(5);
    public int bmg;
    public int bmh;
    int bmi;
    public int type;

    private void resetState() {
        this.bmg = 0;
        this.bmh = 0;
        this.bmi = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long NX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bmg, this.bmh) : ExpandableListView.getPackedPositionForGroup(this.bmg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Aj(int i) {
        return C(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a C(int i, int i2, int i3, int i4) {
        a czr = czr();
        czr.type = i;
        czr.bmg = i2;
        czr.bmh = i3;
        czr.bmi = i4;
        return czr;
    }

    private static a czr() {
        a aVar;
        synchronized (bmc) {
            if (bmc.size() > 0) {
                aVar = bmc.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bmc) {
            if (bmc.size() < 5) {
                bmc.add(this);
            }
        }
    }
}
