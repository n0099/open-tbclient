package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> buT = new ArrayList<>(5);
    public int buX;
    public int buY;
    int buZ;
    public int type;

    private void resetState() {
        this.buX = 0;
        this.buY = 0;
        this.buZ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Qy() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.buX, this.buY) : ExpandableListView.getPackedPositionForGroup(this.buX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a BJ(int i) {
        return D(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a D(int i, int i2, int i3, int i4) {
        a cJP = cJP();
        cJP.type = i;
        cJP.buX = i2;
        cJP.buY = i3;
        cJP.buZ = i4;
        return cJP;
    }

    private static a cJP() {
        a aVar;
        synchronized (buT) {
            if (buT.size() > 0) {
                aVar = buT.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (buT) {
            if (buT.size() < 5) {
                buT.add(this);
            }
        }
    }
}
