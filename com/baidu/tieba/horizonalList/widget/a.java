package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eru = new ArrayList<>(5);
    int erA;
    public int ery;
    public int erz;
    public int type;

    private void Tv() {
        this.ery = 0;
        this.erz = 0;
        this.erA = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aJW() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.ery, this.erz) : ExpandableListView.getPackedPositionForGroup(this.ery);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a oz(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aJX = aJX();
        aJX.type = i;
        aJX.ery = i2;
        aJX.erz = i3;
        aJX.erA = i4;
        return aJX;
    }

    private static a aJX() {
        a aVar;
        synchronized (eru) {
            if (eru.size() > 0) {
                aVar = eru.remove(0);
                aVar.Tv();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eru) {
            if (eru.size() < 5) {
                eru.add(this);
            }
        }
    }
}
