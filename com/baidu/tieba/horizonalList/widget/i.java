package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cwL = new ArrayList<>(5);
    public int cwP;
    public int cwQ;
    int cwR;
    public int type;

    private void aiy() {
        this.cwP = 0;
        this.cwQ = 0;
        this.cwR = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aiB() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cwP, this.cwQ) : ExpandableListView.getPackedPositionForGroup(this.cwP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i jR(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i j(int i, int i2, int i3, int i4) {
        i aiC = aiC();
        aiC.type = i;
        aiC.cwP = i2;
        aiC.cwQ = i3;
        aiC.cwR = i4;
        return aiC;
    }

    private static i aiC() {
        i iVar;
        synchronized (cwL) {
            if (cwL.size() > 0) {
                iVar = cwL.remove(0);
                iVar.aiy();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cwL) {
            if (cwL.size() < 5) {
                cwL.add(this);
            }
        }
    }
}
