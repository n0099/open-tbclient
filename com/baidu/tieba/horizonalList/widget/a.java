package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eBT = new ArrayList<>(5);
    public int eBX;
    public int eBY;
    int eBZ;
    public int type;

    private void UZ() {
        this.eBX = 0;
        this.eBY = 0;
        this.eBZ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aNb() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eBX, this.eBY) : ExpandableListView.getPackedPositionForGroup(this.eBX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ph(int i) {
        return t(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a t(int i, int i2, int i3, int i4) {
        a aNc = aNc();
        aNc.type = i;
        aNc.eBX = i2;
        aNc.eBY = i3;
        aNc.eBZ = i4;
        return aNc;
    }

    private static a aNc() {
        a aVar;
        synchronized (eBT) {
            if (eBT.size() > 0) {
                aVar = eBT.remove(0);
                aVar.UZ();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eBT) {
            if (eBT.size() < 5) {
                eBT.add(this);
            }
        }
    }
}
