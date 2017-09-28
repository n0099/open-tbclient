package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> ddk = new ArrayList<>(5);
    public int ddo;
    public int ddp;
    int ddq;
    public int type;

    private void Kw() {
        this.ddo = 0;
        this.ddp = 0;
        this.ddq = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aqs() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.ddo, this.ddp) : ExpandableListView.getPackedPositionForGroup(this.ddo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lx(int i) {
        return p(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b p(int i, int i2, int i3, int i4) {
        b aqt = aqt();
        aqt.type = i;
        aqt.ddo = i2;
        aqt.ddp = i3;
        aqt.ddq = i4;
        return aqt;
    }

    private static b aqt() {
        b bVar;
        synchronized (ddk) {
            if (ddk.size() > 0) {
                bVar = ddk.remove(0);
                bVar.Kw();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (ddk) {
            if (ddk.size() < 5) {
                ddk.add(this);
            }
        }
    }
}
