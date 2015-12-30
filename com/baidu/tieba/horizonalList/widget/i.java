package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> bEB = new ArrayList<>(5);
    public int bEF;
    public int bEG;
    int bEH;
    public int type;

    private void UT() {
        this.bEF = 0;
        this.bEG = 0;
        this.bEH = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long UV() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bEF, this.bEG) : ExpandableListView.getPackedPositionForGroup(this.bEF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i hL(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i UW = UW();
        UW.type = i;
        UW.bEF = i2;
        UW.bEG = i3;
        UW.bEH = i4;
        return UW;
    }

    private static i UW() {
        i iVar;
        synchronized (bEB) {
            if (bEB.size() > 0) {
                iVar = bEB.remove(0);
                iVar.UT();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (bEB) {
            if (bEB.size() < 5) {
                bEB.add(this);
            }
        }
    }
}
