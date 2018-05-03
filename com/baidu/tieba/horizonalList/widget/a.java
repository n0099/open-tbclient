package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> dGN = new ArrayList<>(5);
    public int dGR;
    public int dGS;
    int dGT;
    public int type;

    private void Lz() {
        this.dGR = 0;
        this.dGS = 0;
        this.dGT = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ayr() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dGR, this.dGS) : ExpandableListView.getPackedPositionForGroup(this.dGR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a mz(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a ays = ays();
        ays.type = i;
        ays.dGR = i2;
        ays.dGS = i3;
        ays.dGT = i4;
        return ays;
    }

    private static a ays() {
        a aVar;
        synchronized (dGN) {
            if (dGN.size() > 0) {
                aVar = dGN.remove(0);
                aVar.Lz();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (dGN) {
            if (dGN.size() < 5) {
                dGN.add(this);
            }
        }
    }
}
