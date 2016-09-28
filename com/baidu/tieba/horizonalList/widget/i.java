package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cLW = new ArrayList<>(5);
    public int cMa;
    public int cMb;
    int cMc;
    public int type;

    private void aok() {
        this.cMa = 0;
        this.cMb = 0;
        this.cMc = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aon() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cMa, this.cMb) : ExpandableListView.getPackedPositionForGroup(this.cMa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kG(int i) {
        return m(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i m(int i, int i2, int i3, int i4) {
        i aoo = aoo();
        aoo.type = i;
        aoo.cMa = i2;
        aoo.cMb = i3;
        aoo.cMc = i4;
        return aoo;
    }

    private static i aoo() {
        i iVar;
        synchronized (cLW) {
            if (cLW.size() > 0) {
                iVar = cLW.remove(0);
                iVar.aok();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cLW) {
            if (cLW.size() < 5) {
                cLW.add(this);
            }
        }
    }
}
