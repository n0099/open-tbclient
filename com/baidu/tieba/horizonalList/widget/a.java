package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eBg = new ArrayList<>(5);
    public int eBk;
    public int eBl;
    int eBm;
    public int type;

    private void UD() {
        this.eBk = 0;
        this.eBl = 0;
        this.eBm = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aMB() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eBk, this.eBl) : ExpandableListView.getPackedPositionForGroup(this.eBk);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a pg(int i) {
        return t(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a t(int i, int i2, int i3, int i4) {
        a aMC = aMC();
        aMC.type = i;
        aMC.eBk = i2;
        aMC.eBl = i3;
        aMC.eBm = i4;
        return aMC;
    }

    private static a aMC() {
        a aVar;
        synchronized (eBg) {
            if (eBg.size() > 0) {
                aVar = eBg.remove(0);
                aVar.UD();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eBg) {
            if (eBg.size() < 5) {
                eBg.add(this);
            }
        }
    }
}
