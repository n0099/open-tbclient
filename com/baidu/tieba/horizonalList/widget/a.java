package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> auz = new ArrayList<>(5);
    public int auD;
    public int auE;
    int auF;
    public int type;

    private void resetState() {
        this.auD = 0;
        this.auE = 0;
        this.auF = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long xh() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.auD, this.auE) : ExpandableListView.getPackedPositionForGroup(this.auD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a vo(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a bMY = bMY();
        bMY.type = i;
        bMY.auD = i2;
        bMY.auE = i3;
        bMY.auF = i4;
        return bMY;
    }

    private static a bMY() {
        a aVar;
        synchronized (auz) {
            if (auz.size() > 0) {
                aVar = auz.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (auz) {
            if (auz.size() < 5) {
                auz.add(this);
            }
        }
    }
}
