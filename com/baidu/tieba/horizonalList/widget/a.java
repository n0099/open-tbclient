package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bgu = new ArrayList<>(5);
    int bgA;
    public int bgy;
    public int bgz;
    public int type;

    private void resetState() {
        this.bgy = 0;
        this.bgz = 0;
        this.bgA = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Ie() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bgy, this.bgz) : ExpandableListView.getPackedPositionForGroup(this.bgy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a xP(int i) {
        return C(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a C(int i, int i2, int i3, int i4) {
        a coy = coy();
        coy.type = i;
        coy.bgy = i2;
        coy.bgz = i3;
        coy.bgA = i4;
        return coy;
    }

    private static a coy() {
        a aVar;
        synchronized (bgu) {
            if (bgu.size() > 0) {
                aVar = bgu.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bgu) {
            if (bgu.size() < 5) {
                bgu.add(this);
            }
        }
    }
}
