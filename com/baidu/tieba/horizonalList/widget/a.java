package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> boY = new ArrayList<>(5);
    public int bpc;
    public int bpd;
    int bpe;
    public int type;

    private void resetState() {
        this.bpc = 0;
        this.bpd = 0;
        this.bpe = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long OA() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bpc, this.bpd) : ExpandableListView.getPackedPositionForGroup(this.bpc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a AK(int i) {
        return C(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a C(int i, int i2, int i3, int i4) {
        a cCZ = cCZ();
        cCZ.type = i;
        cCZ.bpc = i2;
        cCZ.bpd = i3;
        cCZ.bpe = i4;
        return cCZ;
    }

    private static a cCZ() {
        a aVar;
        synchronized (boY) {
            if (boY.size() > 0) {
                aVar = boY.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (boY) {
            if (boY.size() < 5) {
                boY.add(this);
            }
        }
    }
}
