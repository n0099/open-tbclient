package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> gjb = new ArrayList<>(5);
    public int gjf;
    public int gjg;
    int gjh;
    public int type;

    private void aAd() {
        this.gjf = 0;
        this.gjg = 0;
        this.gjh = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bvk() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gjf, this.gjg) : ExpandableListView.getPackedPositionForGroup(this.gjf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a tV(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bvl = bvl();
        bvl.type = i;
        bvl.gjf = i2;
        bvl.gjg = i3;
        bvl.gjh = i4;
        return bvl;
    }

    private static a bvl() {
        a aVar;
        synchronized (gjb) {
            if (gjb.size() > 0) {
                aVar = gjb.remove(0);
                aVar.aAd();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (gjb) {
            if (gjb.size() < 5) {
                gjb.add(this);
            }
        }
    }
}
