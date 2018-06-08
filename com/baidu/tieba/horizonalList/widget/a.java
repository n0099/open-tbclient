package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> dTe = new ArrayList<>(5);
    public int dTi;
    public int dTj;
    int dTk;
    public int type;

    private void OW() {
        this.dTi = 0;
        this.dTj = 0;
        this.dTk = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDk() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dTi, this.dTj) : ExpandableListView.getPackedPositionForGroup(this.dTi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a mK(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aDl = aDl();
        aDl.type = i;
        aDl.dTi = i2;
        aDl.dTj = i3;
        aDl.dTk = i4;
        return aDl;
    }

    private static a aDl() {
        a aVar;
        synchronized (dTe) {
            if (dTe.size() > 0) {
                aVar = dTe.remove(0);
                aVar.OW();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (dTe) {
            if (dTe.size() < 5) {
                dTe.add(this);
            }
        }
    }
}
