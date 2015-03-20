package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bd {
    final /* synthetic */ ba aKO;
    private List<LiveCardData> aKT;
    private List<LiveCardData> aKU;
    private final boolean aKV;

    public bd(ba baVar, List<LiveCardData> list) {
        this.aKO = baVar;
        this.aKT = list;
        if (list != null && list.size() > 1) {
            this.aKV = true;
        } else {
            this.aKV = false;
        }
        this.aKU = T(this.aKT);
    }

    private List<LiveCardData> T(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aKV && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eK(int i) {
        if (this.aKV) {
            int size = this.aKU.size();
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
    public int eL(int i) {
        if (this.aKV) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int JM() {
        if (this.aKT == null) {
            return 0;
        }
        return this.aKT.size();
    }

    public int JN() {
        return this.aKV ? 1 : 0;
    }

    public List<LiveCardData> JO() {
        return this.aKU;
    }
}
