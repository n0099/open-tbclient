package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bIn = new ArrayList<>(5);
    public int bIr;
    public int bIs;
    int bIt;
    public int type;

    private void TP() {
        this.bIr = 0;
        this.bIs = 0;
        this.bIt = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long TR() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bIr, this.bIs) : ExpandableListView.getPackedPositionForGroup(this.bIr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Ci(int i) {
        return H(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a H(int i, int i2, int i3, int i4) {
        a cSH = cSH();
        cSH.type = i;
        cSH.bIr = i2;
        cSH.bIs = i3;
        cSH.bIt = i4;
        return cSH;
    }

    private static a cSH() {
        a aVar;
        synchronized (bIn) {
            if (bIn.size() > 0) {
                aVar = bIn.remove(0);
                aVar.TP();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bIn) {
            if (bIn.size() < 5) {
                bIn.add(this);
            }
        }
    }
}
