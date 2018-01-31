package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> ehZ = new ArrayList<>(5);
    public int eid;
    public int eie;
    int eif;
    public int type;

    private void Sv() {
        this.eid = 0;
        this.eie = 0;
        this.eif = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aBZ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eid, this.eie) : ExpandableListView.getPackedPositionForGroup(this.eid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b oZ(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aCa = aCa();
        aCa.type = i;
        aCa.eid = i2;
        aCa.eie = i3;
        aCa.eif = i4;
        return aCa;
    }

    private static b aCa() {
        b bVar;
        synchronized (ehZ) {
            if (ehZ.size() > 0) {
                bVar = ehZ.remove(0);
                bVar.Sv();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (ehZ) {
            if (ehZ.size() < 5) {
                ehZ.add(this);
            }
        }
    }
}
