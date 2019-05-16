package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> gja = new ArrayList<>(5);
    public int gje;
    public int gjf;
    int gjg;
    public int type;

    private void aAa() {
        this.gje = 0;
        this.gjf = 0;
        this.gjg = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bvh() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gje, this.gjf) : ExpandableListView.getPackedPositionForGroup(this.gje);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a tV(int i) {
        return w(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(int i, int i2, int i3, int i4) {
        a bvi = bvi();
        bvi.type = i;
        bvi.gje = i2;
        bvi.gjf = i3;
        bvi.gjg = i4;
        return bvi;
    }

    private static a bvi() {
        a aVar;
        synchronized (gja) {
            if (gja.size() > 0) {
                aVar = gja.remove(0);
                aVar.aAa();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (gja) {
            if (gja.size() < 5) {
                gja.add(this);
            }
        }
    }
}
