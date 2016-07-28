package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> czA = new ArrayList<>(5);
    public int czE;
    public int czF;
    int czG;
    public int type;

    private void aji() {
        this.czE = 0;
        this.czF = 0;
        this.czG = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ajl() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.czE, this.czF) : ExpandableListView.getPackedPositionForGroup(this.czE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i jX(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i ajm = ajm();
        ajm.type = i;
        ajm.czE = i2;
        ajm.czF = i3;
        ajm.czG = i4;
        return ajm;
    }

    private static i ajm() {
        i iVar;
        synchronized (czA) {
            if (czA.size() > 0) {
                iVar = czA.remove(0);
                iVar.aji();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (czA) {
            if (czA.size() < 5) {
                czA.add(this);
            }
        }
    }
}
