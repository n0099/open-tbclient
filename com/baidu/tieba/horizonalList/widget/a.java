package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> amT = new ArrayList<>(5);
    public int amX;
    public int amY;
    int amZ;
    public int type;

    private void vf() {
        this.amX = 0;
        this.amY = 0;
        this.amZ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long vi() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.amX, this.amY) : ExpandableListView.getPackedPositionForGroup(this.amX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a tn(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bvJ = bvJ();
        bvJ.type = i;
        bvJ.amX = i2;
        bvJ.amY = i3;
        bvJ.amZ = i4;
        return bvJ;
    }

    private static a bvJ() {
        a aVar;
        synchronized (amT) {
            if (amT.size() > 0) {
                aVar = amT.remove(0);
                aVar.vf();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (amT) {
            if (amT.size() < 5) {
                amT.add(this);
            }
        }
    }
}
