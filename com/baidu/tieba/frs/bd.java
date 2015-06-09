package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bd {
    final /* synthetic */ ba aNg;
    private List<LiveCardData> aNm;
    private List<LiveCardData> aNn;
    private final boolean aNo;

    public bd(ba baVar, List<LiveCardData> list) {
        this.aNg = baVar;
        this.aNm = list;
        if (list != null && list.size() > 1) {
            this.aNo = true;
        } else {
            this.aNo = false;
        }
        this.aNn = W(this.aNm);
    }

    private List<LiveCardData> W(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aNo && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eY(int i) {
        if (this.aNo) {
            int size = this.aNn.size();
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
    public int eZ(int i) {
        if (this.aNo) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int KZ() {
        if (this.aNm == null) {
            return 0;
        }
        return this.aNm.size();
    }

    public int La() {
        return this.aNo ? 1 : 0;
    }

    public List<LiveCardData> Lb() {
        return this.aNn;
    }
}
