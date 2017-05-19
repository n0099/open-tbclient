package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h {
    private static ArrayList<h> czT = new ArrayList<>(5);
    public int czX;
    public int czY;
    int czZ;
    public int type;

    private void aiK() {
        this.czX = 0;
        this.czY = 0;
        this.czZ = 0;
        this.type = 0;
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aiN() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.czX, this.czY) : ExpandableListView.getPackedPositionForGroup(this.czX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h ki(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h j(int i, int i2, int i3, int i4) {
        h aiO = aiO();
        aiO.type = i;
        aiO.czX = i2;
        aiO.czY = i3;
        aiO.czZ = i4;
        return aiO;
    }

    private static h aiO() {
        h hVar;
        synchronized (czT) {
            if (czT.size() > 0) {
                hVar = czT.remove(0);
                hVar.aiK();
            } else {
                hVar = new h();
            }
        }
        return hVar;
    }

    public void recycle() {
        synchronized (czT) {
            if (czT.size() < 5) {
                czT.add(this);
            }
        }
    }
}
