package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bmf = new ArrayList<>(5);
    public int bmj;
    public int bmk;
    int bml;
    public int type;

    private void resetState() {
        this.bmj = 0;
        this.bmk = 0;
        this.bml = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long NX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bmj, this.bmk) : ExpandableListView.getPackedPositionForGroup(this.bmj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Aj(int i) {
        return C(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a C(int i, int i2, int i3, int i4) {
        a czs = czs();
        czs.type = i;
        czs.bmj = i2;
        czs.bmk = i3;
        czs.bml = i4;
        return czs;
    }

    private static a czs() {
        a aVar;
        synchronized (bmf) {
            if (bmf.size() > 0) {
                aVar = bmf.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bmf) {
            if (bmf.size() < 5) {
                bmf.add(this);
            }
        }
    }
}
