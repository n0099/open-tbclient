package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eBS = new ArrayList<>(5);
    public int eBW;
    public int eBX;
    int eBY;
    public int type;

    private void UZ() {
        this.eBW = 0;
        this.eBX = 0;
        this.eBY = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aNb() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eBW, this.eBX) : ExpandableListView.getPackedPositionForGroup(this.eBW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ph(int i) {
        return t(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a t(int i, int i2, int i3, int i4) {
        a aNc = aNc();
        aNc.type = i;
        aNc.eBW = i2;
        aNc.eBX = i3;
        aNc.eBY = i4;
        return aNc;
    }

    private static a aNc() {
        a aVar;
        synchronized (eBS) {
            if (eBS.size() > 0) {
                aVar = eBS.remove(0);
                aVar.UZ();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eBS) {
            if (eBS.size() < 5) {
                eBS.add(this);
            }
        }
    }
}
