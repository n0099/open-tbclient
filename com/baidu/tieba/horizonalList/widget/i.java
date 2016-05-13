package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> bSL = new ArrayList<>(5);
    public int bSP;
    public int bSQ;
    int bSR;
    public int type;

    private void aaD() {
        this.bSP = 0;
        this.bSQ = 0;
        this.bSR = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aaG() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bSP, this.bSQ) : ExpandableListView.getPackedPositionForGroup(this.bSP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i is(int i) {
        return i(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i i(int i, int i2, int i3, int i4) {
        i aaH = aaH();
        aaH.type = i;
        aaH.bSP = i2;
        aaH.bSQ = i3;
        aaH.bSR = i4;
        return aaH;
    }

    private static i aaH() {
        i iVar;
        synchronized (bSL) {
            if (bSL.size() > 0) {
                iVar = bSL.remove(0);
                iVar.aaD();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (bSL) {
            if (bSL.size() < 5) {
                bSL.add(this);
            }
        }
    }
}
