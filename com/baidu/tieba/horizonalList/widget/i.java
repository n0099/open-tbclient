package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> bSk = new ArrayList<>(5);
    public int bSo;
    public int bSp;
    int bSq;
    public int type;

    private void aaC() {
        this.bSo = 0;
        this.bSp = 0;
        this.bSq = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aaF() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bSo, this.bSp) : ExpandableListView.getPackedPositionForGroup(this.bSo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i iQ(int i) {
        return h(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i h(int i, int i2, int i3, int i4) {
        i aaG = aaG();
        aaG.type = i;
        aaG.bSo = i2;
        aaG.bSp = i3;
        aaG.bSq = i4;
        return aaG;
    }

    private static i aaG() {
        i iVar;
        synchronized (bSk) {
            if (bSk.size() > 0) {
                iVar = bSk.remove(0);
                iVar.aaC();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (bSk) {
            if (bSk.size() < 5) {
                bSk.add(this);
            }
        }
    }
}
