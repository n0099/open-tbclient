package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bs {
    final /* synthetic */ bp aCo;
    private List<LiveCardData> aCt;
    private List<LiveCardData> aCu;
    private final boolean aCv;

    public bs(bp bpVar, List<LiveCardData> list) {
        this.aCo = bpVar;
        this.aCt = list;
        if (list != null && list.size() > 1) {
            this.aCv = true;
        } else {
            this.aCv = false;
        }
        this.aCu = E(this.aCt);
    }

    private List<LiveCardData> E(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aCv && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eL(int i) {
        if (this.aCv) {
            int size = this.aCu.size();
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
    public int eM(int i) {
        if (this.aCv) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FT() {
        if (this.aCt == null) {
            return 0;
        }
        return this.aCt.size();
    }

    public int FU() {
        return this.aCv ? 1 : 0;
    }

    public List<LiveCardData> FV() {
        return this.aCu;
    }
}
