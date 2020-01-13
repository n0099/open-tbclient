package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> avl = new ArrayList<>(5);
    public int avp;
    public int avq;
    int avr;
    public int type;

    private void resetState() {
        this.avp = 0;
        this.avq = 0;
        this.avr = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long xx() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.avp, this.avq) : ExpandableListView.getPackedPositionForGroup(this.avp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a vt(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a bOh = bOh();
        bOh.type = i;
        bOh.avp = i2;
        bOh.avq = i3;
        bOh.avr = i4;
        return bOh;
    }

    private static a bOh() {
        a aVar;
        synchronized (avl) {
            if (avl.size() > 0) {
                aVar = avl.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (avl) {
            if (avl.size() < 5) {
                avl.add(this);
            }
        }
    }
}
