package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class bd {
    final /* synthetic */ ba aNf;
    private List<LiveCardData> aNl;
    private List<LiveCardData> aNm;
    private final boolean aNn;

    public bd(ba baVar, List<LiveCardData> list) {
        this.aNf = baVar;
        this.aNl = list;
        if (list != null && list.size() > 1) {
            this.aNn = true;
        } else {
            this.aNn = false;
        }
        this.aNm = W(this.aNl);
    }

    private List<LiveCardData> W(List<LiveCardData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            if (this.aNn && list.size() >= 1) {
                arrayList.add(0, list.get(list.size() - 1));
                arrayList.add(list.get(0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eY(int i) {
        if (this.aNn) {
            int size = this.aNm.size();
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
        if (this.aNn) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int KY() {
        if (this.aNl == null) {
            return 0;
        }
        return this.aNl.size();
    }

    public int KZ() {
        return this.aNn ? 1 : 0;
    }

    public List<LiveCardData> La() {
        return this.aNm;
    }
}
