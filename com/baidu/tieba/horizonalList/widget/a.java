package com.baidu.tieba.horizonalList.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a {
    private static ArrayList<a> bJp = new ArrayList<>(5);
    public int bJt;
    public int bJu;
    int bJv;
    public int type;

    private void Wb() {
        this.bJt = 0;
        this.bJu = 0;
        this.bJv = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Wd() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bJt, this.bJu) : ExpandableListView.getPackedPositionForGroup(this.bJt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a Dx(int i) {
        return J(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a J(int i, int i2, int i3, int i4) {
        a cUs = cUs();
        cUs.type = i;
        cUs.bJt = i2;
        cUs.bJu = i3;
        cUs.bJv = i4;
        return cUs;
    }

    private static a cUs() {
        a aVar;
        synchronized (bJp) {
            if (bJp.size() > 0) {
                aVar = bJp.remove(0);
                aVar.Wb();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bJp) {
            if (bJp.size() < 5) {
                bJp.add(this);
            }
        }
    }
}
