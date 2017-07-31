package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> cXw = new ArrayList<>(5);
    public int cXA;
    public int cXB;
    int cXC;
    public int type;

    private void resetState() {
        this.cXA = 0;
        this.cXB = 0;
        this.cXC = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long apq() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cXA, this.cXB) : ExpandableListView.getPackedPositionForGroup(this.cXA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b kY(int i) {
        return n(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b n(int i, int i2, int i3, int i4) {
        b apr = apr();
        apr.type = i;
        apr.cXA = i2;
        apr.cXB = i3;
        apr.cXC = i4;
        return apr;
    }

    private static b apr() {
        b bVar;
        synchronized (cXw) {
            if (cXw.size() > 0) {
                bVar = cXw.remove(0);
                bVar.resetState();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (cXw) {
            if (cXw.size() < 5) {
                cXw.add(this);
            }
        }
    }
}
