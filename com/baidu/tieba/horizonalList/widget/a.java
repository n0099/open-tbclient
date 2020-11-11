package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bBe = new ArrayList<>(5);
    public int bBi;
    public int bBj;
    int bBk;
    public int type;

    private void resetState() {
        this.bBi = 0;
        this.bBj = 0;
        this.bBk = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Ti() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bBi, this.bBj) : ExpandableListView.getPackedPositionForGroup(this.bBi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a BW(int i) {
        return D(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a D(int i, int i2, int i3, int i4) {
        a cMq = cMq();
        cMq.type = i;
        cMq.bBi = i2;
        cMq.bBj = i3;
        cMq.bBk = i4;
        return cMq;
    }

    private static a cMq() {
        a aVar;
        synchronized (bBe) {
            if (bBe.size() > 0) {
                aVar = bBe.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bBe) {
            if (bBe.size() < 5) {
                bBe.add(this);
            }
        }
    }
}
