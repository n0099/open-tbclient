package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dcX = new ArrayList<>(5);
    public int ddb;
    public int ddc;
    int ddd;
    public int type;

    private void Kq() {
        this.ddb = 0;
        this.ddc = 0;
        this.ddd = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aqn() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.ddb, this.ddc) : ExpandableListView.getPackedPositionForGroup(this.ddb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lw(int i) {
        return p(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b p(int i, int i2, int i3, int i4) {
        b aqo = aqo();
        aqo.type = i;
        aqo.ddb = i2;
        aqo.ddc = i3;
        aqo.ddd = i4;
        return aqo;
    }

    private static b aqo() {
        b bVar;
        synchronized (dcX) {
            if (dcX.size() > 0) {
                bVar = dcX.remove(0);
                bVar.Kq();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dcX) {
            if (dcX.size() < 5) {
                dcX.add(this);
            }
        }
    }
}
