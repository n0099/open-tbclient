package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bEB = new ArrayList<>(5);
    public int bEF;
    public int bEG;
    int bEH;
    public int type;

    private void UW() {
        this.bEF = 0;
        this.bEG = 0;
        this.bEH = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long UZ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bEF, this.bEG) : ExpandableListView.getPackedPositionForGroup(this.bEF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Dj(int i) {
        return I(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a I(int i, int i2, int i3, int i4) {
        a cRm = cRm();
        cRm.type = i;
        cRm.bEF = i2;
        cRm.bEG = i3;
        cRm.bEH = i4;
        return cRm;
    }

    private static a cRm() {
        a aVar;
        synchronized (bEB) {
            if (bEB.size() > 0) {
                aVar = bEB.remove(0);
                aVar.UW();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bEB) {
            if (bEB.size() < 5) {
                bEB.add(this);
            }
        }
    }
}
