package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> fSa = new ArrayList<>(5);
    public int fSe;
    public int fSf;
    int fSg;
    public int type;

    private void auZ() {
        this.fSe = 0;
        this.fSf = 0;
        this.fSg = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bnI() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.fSe, this.fSf) : ExpandableListView.getPackedPositionForGroup(this.fSe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a sS(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bnJ = bnJ();
        bnJ.type = i;
        bnJ.fSe = i2;
        bnJ.fSf = i3;
        bnJ.fSg = i4;
        return bnJ;
    }

    private static a bnJ() {
        a aVar;
        synchronized (fSa) {
            if (fSa.size() > 0) {
                aVar = fSa.remove(0);
                aVar.auZ();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (fSa) {
            if (fSa.size() < 5) {
                fSa.add(this);
            }
        }
    }
}
