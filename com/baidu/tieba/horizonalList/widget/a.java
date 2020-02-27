package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> azB = new ArrayList<>(5);
    public int azF;
    public int azG;
    int azH;
    public int type;

    private void resetState() {
        this.azF = 0;
        this.azG = 0;
        this.azH = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zO() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azF, this.azG) : ExpandableListView.getPackedPositionForGroup(this.azF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a vz(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a bPJ = bPJ();
        bPJ.type = i;
        bPJ.azF = i2;
        bPJ.azG = i3;
        bPJ.azH = i4;
        return bPJ;
    }

    private static a bPJ() {
        a aVar;
        synchronized (azB) {
            if (azB.size() > 0) {
                aVar = azB.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azB) {
            if (azB.size() < 5) {
                azB.add(this);
            }
        }
    }
}
