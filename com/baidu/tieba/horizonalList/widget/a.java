package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eyp = new ArrayList<>(5);
    public int eyt;
    public int eyu;
    int eyv;
    public int type;

    private void UB() {
        this.eyt = 0;
        this.eyu = 0;
        this.eyv = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aLN() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eyt, this.eyu) : ExpandableListView.getPackedPositionForGroup(this.eyt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a oT(int i) {
        return t(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a t(int i, int i2, int i3, int i4) {
        a aLO = aLO();
        aLO.type = i;
        aLO.eyt = i2;
        aLO.eyu = i3;
        aLO.eyv = i4;
        return aLO;
    }

    private static a aLO() {
        a aVar;
        synchronized (eyp) {
            if (eyp.size() > 0) {
                aVar = eyp.remove(0);
                aVar.UB();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eyp) {
            if (eyp.size() < 5) {
                eyp.add(this);
            }
        }
    }
}
