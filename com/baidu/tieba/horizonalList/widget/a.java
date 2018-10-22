package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> eqa = new ArrayList<>(5);
    public int eqe;
    public int eqf;
    int eqg;
    public int type;

    private void Tm() {
        this.eqe = 0;
        this.eqf = 0;
        this.eqg = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aKy() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.eqe, this.eqf) : ExpandableListView.getPackedPositionForGroup(this.eqe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a oh(int i) {
        return s(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a s(int i, int i2, int i3, int i4) {
        a aKz = aKz();
        aKz.type = i;
        aKz.eqe = i2;
        aKz.eqf = i3;
        aKz.eqg = i4;
        return aKz;
    }

    private static a aKz() {
        a aVar;
        synchronized (eqa) {
            if (eqa.size() > 0) {
                aVar = eqa.remove(0);
                aVar.Tm();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (eqa) {
            if (eqa.size() < 5) {
                eqa.add(this);
            }
        }
    }
}
