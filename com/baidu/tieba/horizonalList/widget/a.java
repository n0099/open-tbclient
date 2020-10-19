package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bsL = new ArrayList<>(5);
    public int bsP;
    public int bsQ;
    int bsR;
    public int type;

    private void resetState() {
        this.bsP = 0;
        this.bsQ = 0;
        this.bsR = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long PF() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bsP, this.bsQ) : ExpandableListView.getPackedPositionForGroup(this.bsP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Bq(int i) {
        return C(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a C(int i, int i2, int i3, int i4) {
        a cGI = cGI();
        cGI.type = i;
        cGI.bsP = i2;
        cGI.bsQ = i3;
        cGI.bsR = i4;
        return cGI;
    }

    private static a cGI() {
        a aVar;
        synchronized (bsL) {
            if (bsL.size() > 0) {
                aVar = bsL.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bsL) {
            if (bsL.size() < 5) {
                bsL.add(this);
            }
        }
    }
}
