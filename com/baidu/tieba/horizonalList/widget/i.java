package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i {
    private static ArrayList<i> cET = new ArrayList<>(5);
    public int cEX;
    public int cEY;
    int cEZ;
    public int type;

    private void akZ() {
        this.cEX = 0;
        this.cEY = 0;
        this.cEZ = 0;
        this.type = 0;
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long alc() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.cEX, this.cEY) : ExpandableListView.getPackedPositionForGroup(this.cEX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i ko(int i) {
        return k(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(int i, int i2, int i3, int i4) {
        i ald = ald();
        ald.type = i;
        ald.cEX = i2;
        ald.cEY = i3;
        ald.cEZ = i4;
        return ald;
    }

    private static i ald() {
        i iVar;
        synchronized (cET) {
            if (cET.size() > 0) {
                iVar = cET.remove(0);
                iVar.akZ();
            } else {
                iVar = new i();
            }
        }
        return iVar;
    }

    public void recycle() {
        synchronized (cET) {
            if (cET.size() < 5) {
                cET.add(this);
            }
        }
    }
}
