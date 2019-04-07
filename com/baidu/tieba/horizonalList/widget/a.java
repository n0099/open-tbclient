package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> fRN = new ArrayList<>(5);
    public int fRR;
    public int fRS;
    int fRT;
    public int type;

    private void auV() {
        this.fRR = 0;
        this.fRS = 0;
        this.fRT = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bnE() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.fRR, this.fRS) : ExpandableListView.getPackedPositionForGroup(this.fRR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a sO(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bnF = bnF();
        bnF.type = i;
        bnF.fRR = i2;
        bnF.fRS = i3;
        bnF.fRT = i4;
        return bnF;
    }

    private static a bnF() {
        a aVar;
        synchronized (fRN) {
            if (fRN.size() > 0) {
                aVar = fRN.remove(0);
                aVar.auV();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (fRN) {
            if (fRN.size() < 5) {
                fRN.add(this);
            }
        }
    }
}
