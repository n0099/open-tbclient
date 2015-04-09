package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bd {
    final /* synthetic */ ba aKY;
    private List<LiveCardData> aLd;
    private List<LiveCardData> aLe;
    private final boolean aLf;

    public bd(ba baVar, List<LiveCardData> list) {
        this.aKY = baVar;
        this.aLd = list;
        if (list != null && list.size() > 1) {
            this.aLf = true;
        } else {
            this.aLf = false;
        }
        this.aLe = T(this.aLd);
    }

    private List<LiveCardData> T(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aLf && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eK(int i) {
        if (this.aLf) {
            int size = this.aLe.size();
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
        if (this.aLf) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int JT() {
        if (this.aLd == null) {
            return 0;
        }
        return this.aLd.size();
    }

    public int JU() {
        return this.aLf ? 1 : 0;
    }

    public List<LiveCardData> JV() {
        return this.aLe;
    }
}
