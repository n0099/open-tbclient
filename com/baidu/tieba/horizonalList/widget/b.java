package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> elX = new ArrayList<>(5);
    public int emb;
    public int emc;
    int emd;
    public int type;

    private void Tb() {
        this.emb = 0;
        this.emc = 0;
        this.emd = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDs() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.emb, this.emc) : ExpandableListView.getPackedPositionForGroup(this.emb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b pa(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aDt = aDt();
        aDt.type = i;
        aDt.emb = i2;
        aDt.emc = i3;
        aDt.emd = i4;
        return aDt;
    }

    private static b aDt() {
        b bVar;
        synchronized (elX) {
            if (elX.size() > 0) {
                bVar = elX.remove(0);
                bVar.Tb();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (elX) {
            if (elX.size() < 5) {
                elX.add(this);
            }
        }
    }
}
