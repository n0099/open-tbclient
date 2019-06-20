package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> gjd = new ArrayList<>(5);
    public int gjh;
    public int gji;
    int gjj;
    public int type;

    private void aAd() {
        this.gjh = 0;
        this.gji = 0;
        this.gjj = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bvl() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gjh, this.gji) : ExpandableListView.getPackedPositionForGroup(this.gjh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a tV(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bvm = bvm();
        bvm.type = i;
        bvm.gjh = i2;
        bvm.gji = i3;
        bvm.gjj = i4;
        return bvm;
    }

    private static a bvm() {
        a aVar;
        synchronized (gjd) {
            if (gjd.size() > 0) {
                aVar = gjd.remove(0);
                aVar.aAd();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (gjd) {
            if (gjd.size() < 5) {
                gjd.add(this);
            }
        }
    }
}
