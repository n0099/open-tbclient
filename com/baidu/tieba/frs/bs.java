package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bs {
    final /* synthetic */ bp aCe;
    private List<LiveCardData> aCj;
    private List<LiveCardData> aCk;
    private final boolean aCl;

    public bs(bp bpVar, List<LiveCardData> list) {
        this.aCe = bpVar;
        this.aCj = list;
        if (list != null && list.size() > 1) {
            this.aCl = true;
        } else {
            this.aCl = false;
        }
        this.aCk = E(this.aCj);
    }

    private List<LiveCardData> E(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aCl && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eL(int i) {
        if (this.aCl) {
            int size = this.aCk.size();
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
        if (this.aCl) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FR() {
        if (this.aCj == null) {
            return 0;
        }
        return this.aCj.size();
    }

    public int FS() {
        return this.aCl ? 1 : 0;
    }

    public List<LiveCardData> FT() {
        return this.aCk;
    }
}
