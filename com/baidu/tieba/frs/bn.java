package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bn {
    final /* synthetic */ bk aEO;
    private List<LiveCardData> aET;
    private List<LiveCardData> aEU;
    private final boolean aEV;

    public bn(bk bkVar, List<LiveCardData> list) {
        this.aEO = bkVar;
        this.aET = list;
        if (list != null && list.size() > 1) {
            this.aEV = true;
        } else {
            this.aEV = false;
        }
        this.aEU = Q(this.aET);
    }

    private List<LiveCardData> Q(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aEV && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eP(int i) {
        if (this.aEV) {
            int size = this.aEU.size();
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
        if (this.aEV) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gq() {
        if (this.aET == null) {
            return 0;
        }
        return this.aET.size();
    }

    public int Gr() {
        return this.aEV ? 1 : 0;
    }

    public List<LiveCardData> Gs() {
        return this.aEU;
    }
}
