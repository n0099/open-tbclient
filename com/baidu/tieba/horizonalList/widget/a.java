package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> azR = new ArrayList<>(5);
    public int azV;
    public int azW;
    int azX;
    public int type;

    private void resetState() {
        this.azV = 0;
        this.azW = 0;
        this.azX = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azV, this.azW) : ExpandableListView.getPackedPositionForGroup(this.azV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a vH(int i) {
        return A(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a A(int i, int i2, int i3, int i4) {
        a bQe = bQe();
        bQe.type = i;
        bQe.azV = i2;
        bQe.azW = i3;
        bQe.azX = i4;
        return bQe;
    }

    private static a bQe() {
        a aVar;
        synchronized (azR) {
            if (azR.size() > 0) {
                aVar = azR.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azR) {
            if (azR.size() < 5) {
                azR.add(this);
            }
        }
    }
}
