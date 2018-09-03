package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eaN = new ArrayList<>(5);
    public int eaR;
    public int eaS;
    int eaT;
    public int type;

    private void PD() {
        this.eaR = 0;
        this.eaS = 0;
        this.eaT = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aER() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eaR, this.eaS) : ExpandableListView.getPackedPositionForGroup(this.eaR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a nf(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a r(int i, int i2, int i3, int i4) {
        a aES = aES();
        aES.type = i;
        aES.eaR = i2;
        aES.eaS = i3;
        aES.eaT = i4;
        return aES;
    }

    private static a aES() {
        a aVar;
        synchronized (eaN) {
            if (eaN.size() > 0) {
                aVar = eaN.remove(0);
                aVar.PD();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eaN) {
            if (eaN.size() < 5) {
                eaN.add(this);
            }
        }
    }
}
