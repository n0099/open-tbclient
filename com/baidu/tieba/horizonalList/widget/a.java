package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> baR = new ArrayList<>(5);
    public int baV;
    public int baW;
    int baX;
    public int type;

    private void resetState() {
        this.baV = 0;
        this.baW = 0;
        this.baX = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long GL() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.baV, this.baW) : ExpandableListView.getPackedPositionForGroup(this.baV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a wL(int i) {
        return B(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a B(int i, int i2, int i3, int i4) {
        a chc = chc();
        chc.type = i;
        chc.baV = i2;
        chc.baW = i3;
        chc.baX = i4;
        return chc;
    }

    private static a chc() {
        a aVar;
        synchronized (baR) {
            if (baR.size() > 0) {
                aVar = baR.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (baR) {
            if (baR.size() < 5) {
                baR.add(this);
            }
        }
    }
}
