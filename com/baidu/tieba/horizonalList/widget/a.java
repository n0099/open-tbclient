package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> dHT = new ArrayList<>(5);
    public int dHX;
    public int dHY;
    int dHZ;
    public int type;

    private void Lx() {
        this.dHX = 0;
        this.dHY = 0;
        this.dHZ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ayp() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dHX, this.dHY) : ExpandableListView.getPackedPositionForGroup(this.dHX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a my(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a ayq = ayq();
        ayq.type = i;
        ayq.dHX = i2;
        ayq.dHY = i3;
        ayq.dHZ = i4;
        return ayq;
    }

    private static a ayq() {
        a aVar;
        synchronized (dHT) {
            if (dHT.size() > 0) {
                aVar = dHT.remove(0);
                aVar.Lx();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (dHT) {
            if (dHT.size() < 5) {
                dHT.add(this);
            }
        }
    }
}
