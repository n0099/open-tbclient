package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> grY = new ArrayList<>(5);
    public int gsc;
    public int gsd;
    int gse;
    public int type;

    private void aBH() {
        this.gsc = 0;
        this.gsd = 0;
        this.gse = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long byS() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gsc, this.gsd) : ExpandableListView.getPackedPositionForGroup(this.gsc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a uA(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a byT = byT();
        byT.type = i;
        byT.gsc = i2;
        byT.gsd = i3;
        byT.gse = i4;
        return byT;
    }

    private static a byT() {
        a aVar;
        synchronized (grY) {
            if (grY.size() > 0) {
                aVar = grY.remove(0);
                aVar.aBH();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (grY) {
            if (grY.size() < 5) {
                grY.add(this);
            }
        }
    }
}
