package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bga = new ArrayList<>(5);
    public int bge;
    public int bgf;
    int bgg;
    public int type;

    private void resetState() {
        this.bge = 0;
        this.bgf = 0;
        this.bgg = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long HY() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bge, this.bgf) : ExpandableListView.getPackedPositionForGroup(this.bge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a xx(int i) {
        return B(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a B(int i, int i2, int i3, int i4) {
        a ckY = ckY();
        ckY.type = i;
        ckY.bge = i2;
        ckY.bgf = i3;
        ckY.bgg = i4;
        return ckY;
    }

    private static a ckY() {
        a aVar;
        synchronized (bga) {
            if (bga.size() > 0) {
                aVar = bga.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bga) {
            if (bga.size() < 5) {
                bga.add(this);
            }
        }
    }
}
