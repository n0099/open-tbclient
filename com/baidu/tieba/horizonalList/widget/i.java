package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cLf = new ArrayList<>(5);
    public int cLj;
    public int cLk;
    int cLl;
    public int type;

    private void anW() {
        this.cLj = 0;
        this.cLk = 0;
        this.cLl = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long anZ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cLj, this.cLk) : ExpandableListView.getPackedPositionForGroup(this.cLj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i kA(int i) {
        return l(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i l(int i, int i2, int i3, int i4) {
        i aoa = aoa();
        aoa.type = i;
        aoa.cLj = i2;
        aoa.cLk = i3;
        aoa.cLl = i4;
        return aoa;
    }

    private static i aoa() {
        i iVar;
        synchronized (cLf) {
            if (cLf.size() > 0) {
                iVar = cLf.remove(0);
                iVar.anW();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cLf) {
            if (cLf.size() < 5) {
                cLf.add(this);
            }
        }
    }
}
