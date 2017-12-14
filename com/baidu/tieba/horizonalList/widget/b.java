package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> dub = new ArrayList<>(5);
    public int duf;
    public int dug;
    int duh;
    public int type;

    private void Lg() {
        this.duf = 0;
        this.dug = 0;
        this.duh = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long auM() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.duf, this.dug) : ExpandableListView.getPackedPositionForGroup(this.duf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b mp(int i) {
        return r(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(int i, int i2, int i3, int i4) {
        b auN = auN();
        auN.type = i;
        auN.duf = i2;
        auN.dug = i3;
        auN.duh = i4;
        return auN;
    }

    private static b auN() {
        b bVar;
        synchronized (dub) {
            if (dub.size() > 0) {
                bVar = dub.remove(0);
                bVar.Lg();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (dub) {
            if (dub.size() < 5) {
                dub.add(this);
            }
        }
    }
}
