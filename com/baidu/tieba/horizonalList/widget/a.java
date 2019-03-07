package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> fRZ = new ArrayList<>(5);
    public int fSd;
    public int fSe;
    int fSf;
    public int type;

    private void auY() {
        this.fSd = 0;
        this.fSe = 0;
        this.fSf = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bnH() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.fSd, this.fSe) : ExpandableListView.getPackedPositionForGroup(this.fSd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a sS(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bnI = bnI();
        bnI.type = i;
        bnI.fSd = i2;
        bnI.fSe = i3;
        bnI.fSf = i4;
        return bnI;
    }

    private static a bnI() {
        a aVar;
        synchronized (fRZ) {
            if (fRZ.size() > 0) {
                aVar = fRZ.remove(0);
                aVar.auY();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (fRZ) {
            if (fRZ.size() < 5) {
                fRZ.add(this);
            }
        }
    }
}
