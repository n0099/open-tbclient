package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> aTy = new ArrayList<>(5);
    public int aTC;
    public int aTD;
    int aTE;
    public int type;

    private void resetState() {
        this.aTC = 0;
        this.aTD = 0;
        this.aTE = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long EV() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.aTC, this.aTD) : ExpandableListView.getPackedPositionForGroup(this.aTC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a wf(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a caE = caE();
        caE.type = i;
        caE.aTC = i2;
        caE.aTD = i3;
        caE.aTE = i4;
        return caE;
    }

    private static a caE() {
        a aVar;
        synchronized (aTy) {
            if (aTy.size() > 0) {
                aVar = aTy.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (aTy) {
            if (aTy.size() < 5) {
                aTy.add(this);
            }
        }
    }
}
