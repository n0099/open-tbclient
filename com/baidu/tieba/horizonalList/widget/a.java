package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bED = new ArrayList<>(5);
    public int bEH;
    public int bEI;
    int bEJ;
    public int type;

    private void Si() {
        this.bEH = 0;
        this.bEI = 0;
        this.bEJ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Sk() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bEH, this.bEI) : ExpandableListView.getPackedPositionForGroup(this.bEH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a BQ(int i) {
        return J(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a J(int i, int i2, int i3, int i4) {
        a cQB = cQB();
        cQB.type = i;
        cQB.bEH = i2;
        cQB.bEI = i3;
        cQB.bEJ = i4;
        return cQB;
    }

    private static a cQB() {
        a aVar;
        synchronized (bED) {
            if (bED.size() > 0) {
                aVar = bED.remove(0);
                aVar.Si();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bED) {
            if (bED.size() < 5) {
                bED.add(this);
            }
        }
    }
}
