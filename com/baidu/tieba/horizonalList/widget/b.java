package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> duf = new ArrayList<>(5);
    public int duj;
    public int duk;
    int dul;
    public int type;

    private void Lg() {
        this.duj = 0;
        this.duk = 0;
        this.dul = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long auM() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.duj, this.duk) : ExpandableListView.getPackedPositionForGroup(this.duj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b mp(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(int i, int i2, int i3, int i4) {
        b auN = auN();
        auN.type = i;
        auN.duj = i2;
        auN.duk = i3;
        auN.dul = i4;
        return auN;
    }

    private static b auN() {
        b bVar;
        synchronized (duf) {
            if (duf.size() > 0) {
                bVar = duf.remove(0);
                bVar.Lg();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (duf) {
            if (duf.size() < 5) {
                duf.add(this);
            }
        }
    }
}
