package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> cZv = new ArrayList<>(5);
    public int cZA;
    int cZB;
    public int cZz;
    public int type;

    private void resetState() {
        this.cZz = 0;
        this.cZA = 0;
        this.cZB = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long apX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cZz, this.cZA) : ExpandableListView.getPackedPositionForGroup(this.cZz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b li(int i) {
        return o(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b o(int i, int i2, int i3, int i4) {
        b apY = apY();
        apY.type = i;
        apY.cZz = i2;
        apY.cZA = i3;
        apY.cZB = i4;
        return apY;
    }

    private static b apY() {
        b bVar;
        synchronized (cZv) {
            if (cZv.size() > 0) {
                bVar = cZv.remove(0);
                bVar.resetState();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (cZv) {
            if (cZv.size() < 5) {
                cZv.add(this);
            }
        }
    }
}
