package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> gqh = new ArrayList<>(5);
    public int gql;
    public int gqm;
    int gqn;
    public int type;

    private void aBt() {
        this.gql = 0;
        this.gqm = 0;
        this.gqn = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bye() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.gql, this.gqm) : ExpandableListView.getPackedPositionForGroup(this.gql);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a uw(int i) {
        return x(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a x(int i, int i2, int i3, int i4) {
        a byf = byf();
        byf.type = i;
        byf.gql = i2;
        byf.gqm = i3;
        byf.gqn = i4;
        return byf;
    }

    private static a byf() {
        a aVar;
        synchronized (gqh) {
            if (gqh.size() > 0) {
                aVar = gqh.remove(0);
                aVar.aBt();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (gqh) {
            if (gqh.size() < 5) {
                gqh.add(this);
            }
        }
    }
}
