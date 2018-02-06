package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b {
    private static ArrayList<b> emj = new ArrayList<>(5);
    public int emn;
    public int emo;
    int emp;
    public int type;

    private void Tc() {
        this.emn = 0;
        this.emo = 0;
        this.emp = 0;
        this.type = 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDt() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.emn, this.emo) : ExpandableListView.getPackedPositionForGroup(this.emn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b pa(int i) {
        return z(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b z(int i, int i2, int i3, int i4) {
        b aDu = aDu();
        aDu.type = i;
        aDu.emn = i2;
        aDu.emo = i3;
        aDu.emp = i4;
        return aDu;
    }

    private static b aDu() {
        b bVar;
        synchronized (emj) {
            if (emj.size() > 0) {
                bVar = emj.remove(0);
                bVar.Tc();
            } else {
                bVar = new b();
            }
        }
        return bVar;
    }

    public void recycle() {
        synchronized (emj) {
            if (emj.size() < 5) {
                emj.add(this);
            }
        }
    }
}
