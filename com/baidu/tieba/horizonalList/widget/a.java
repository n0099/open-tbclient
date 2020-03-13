package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> azD = new ArrayList<>(5);
    public int azH;
    public int azI;
    int azJ;
    public int type;

    private void resetState() {
        this.azH = 0;
        this.azI = 0;
        this.azJ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zQ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azH, this.azI) : ExpandableListView.getPackedPositionForGroup(this.azH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a vz(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a bPM = bPM();
        bPM.type = i;
        bPM.azH = i2;
        bPM.azI = i3;
        bPM.azJ = i4;
        return bPM;
    }

    private static a bPM() {
        a aVar;
        synchronized (azD) {
            if (azD.size() > 0) {
                aVar = azD.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azD) {
            if (azD.size() < 5) {
                azD.add(this);
            }
        }
    }
}
