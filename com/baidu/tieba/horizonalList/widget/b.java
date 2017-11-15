package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dlf = new ArrayList<>(5);
    public int dlj;
    public int dlk;
    int dll;
    public int type;

    private void KK() {
        this.dlj = 0;
        this.dlk = 0;
        this.dll = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ata() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.dlj, this.dlk) : ExpandableListView.getPackedPositionForGroup(this.dlj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lN(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(int i, int i2, int i3, int i4) {
        b atb = atb();
        atb.type = i;
        atb.dlj = i2;
        atb.dlk = i3;
        atb.dll = i4;
        return atb;
    }

    private static b atb() {
        b bVar;
        synchronized (dlf) {
            if (dlf.size() > 0) {
                bVar = dlf.remove(0);
                bVar.KK();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dlf) {
            if (dlf.size() < 5) {
                dlf.add(this);
            }
        }
    }
}
