package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eii = new ArrayList<>(5);
    public int eim;
    public int ein;
    int eio;
    public int type;

    private void Rq() {
        this.eim = 0;
        this.ein = 0;
        this.eio = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aHg() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eim, this.ein) : ExpandableListView.getPackedPositionForGroup(this.eim);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a nJ(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aHh = aHh();
        aHh.type = i;
        aHh.eim = i2;
        aHh.ein = i3;
        aHh.eio = i4;
        return aHh;
    }

    private static a aHh() {
        a aVar;
        synchronized (eii) {
            if (eii.size() > 0) {
                aVar = eii.remove(0);
                aVar.Rq();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eii) {
            if (eii.size() < 5) {
                eii.add(this);
            }
        }
    }
}
