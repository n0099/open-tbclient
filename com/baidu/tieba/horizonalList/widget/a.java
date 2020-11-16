package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bzt = new ArrayList<>(5);
    public int bzx;
    public int bzy;
    int bzz;
    public int type;

    private void resetState() {
        this.bzx = 0;
        this.bzy = 0;
        this.bzz = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Sz() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bzx, this.bzy) : ExpandableListView.getPackedPositionForGroup(this.bzx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Cu(int i) {
        return E(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a E(int i, int i2, int i3, int i4) {
        a cLX = cLX();
        cLX.type = i;
        cLX.bzx = i2;
        cLX.bzy = i3;
        cLX.bzz = i4;
        return cLX;
    }

    private static a cLX() {
        a aVar;
        synchronized (bzt) {
            if (bzt.size() > 0) {
                aVar = bzt.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bzt) {
            if (bzt.size() < 5) {
                bzt.add(this);
            }
        }
    }
}
