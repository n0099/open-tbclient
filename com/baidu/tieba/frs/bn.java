package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bn {
    final /* synthetic */ bk aER;
    private List<LiveCardData> aEW;
    private List<LiveCardData> aEX;
    private final boolean aEY;

    public bn(bk bkVar, List<LiveCardData> list) {
        this.aER = bkVar;
        this.aEW = list;
        if (list != null && list.size() > 1) {
            this.aEY = true;
        } else {
            this.aEY = false;
        }
        this.aEX = Q(this.aEW);
    }

    private List<LiveCardData> Q(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aEY && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eP(int i) {
        if (this.aEY) {
            int size = this.aEX.size();
            if (i == 0) {
                return size - 2;
            }
            if (i == size - 1) {
                return 1;
            }
            return i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eQ(int i) {
        if (this.aEY) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gw() {
        if (this.aEW == null) {
            return 0;
        }
        return this.aEW.size();
    }

    public int Gx() {
        return this.aEY ? 1 : 0;
    }

    public List<LiveCardData> Gy() {
        return this.aEX;
    }
}
