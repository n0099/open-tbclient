package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> gpp = new ArrayList<>(5);
    public int gpt;
    public int gpu;
    int gpv;
    public int type;

    private void aBr() {
        this.gpt = 0;
        this.gpu = 0;
        this.gpv = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bxQ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gpt, this.gpu) : ExpandableListView.getPackedPositionForGroup(this.gpt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a uu(int i) {
        return x(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a x(int i, int i2, int i3, int i4) {
        a bxR = bxR();
        bxR.type = i;
        bxR.gpt = i2;
        bxR.gpu = i3;
        bxR.gpv = i4;
        return bxR;
    }

    private static a bxR() {
        a aVar;
        synchronized (gpp) {
            if (gpp.size() > 0) {
                aVar = gpp.remove(0);
                aVar.aBr();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (gpp) {
            if (gpp.size() < 5) {
                gpp.add(this);
            }
        }
    }
}
