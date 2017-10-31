package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dkL = new ArrayList<>(5);
    public int dkP;
    public int dkQ;
    int dkR;
    public int type;

    private void Kz() {
        this.dkP = 0;
        this.dkQ = 0;
        this.dkR = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long asJ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dkP, this.dkQ) : ExpandableListView.getPackedPositionForGroup(this.dkP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lN(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(int i, int i2, int i3, int i4) {
        b asK = asK();
        asK.type = i;
        asK.dkP = i2;
        asK.dkQ = i3;
        asK.dkR = i4;
        return asK;
    }

    private static b asK() {
        b bVar;
        synchronized (dkL) {
            if (dkL.size() > 0) {
                bVar = dkL.remove(0);
                bVar.Kz();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dkL) {
            if (dkL.size() < 5) {
                dkL.add(this);
            }
        }
    }
}
