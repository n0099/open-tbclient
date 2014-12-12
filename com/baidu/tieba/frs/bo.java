package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bo {
    final /* synthetic */ bl aDP;
    private List<LiveCardData> aDU;
    private List<LiveCardData> aDV;
    private final boolean aDW;

    public bo(bl blVar, List<LiveCardData> list) {
        this.aDP = blVar;
        this.aDU = list;
        if (list != null && list.size() > 1) {
            this.aDW = true;
        } else {
            this.aDW = false;
        }
        this.aDV = O(this.aDU);
    }

    private List<LiveCardData> O(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aDW && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eJ(int i) {
        if (this.aDW) {
            int size = this.aDV.size();
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
    public int eK(int i) {
        if (this.aDW) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FZ() {
        if (this.aDU == null) {
            return 0;
        }
        return this.aDU.size();
    }

    public int Ga() {
        return this.aDW ? 1 : 0;
    }

    public List<LiveCardData> Gb() {
        return this.aDV;
    }
}
