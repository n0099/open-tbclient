package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements et {
    final /* synthetic */ o bjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bjp = oVar;
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
    }

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        cd cdVar4;
        SparseArray sparseArray;
        int ac;
        cdVar = this.bjp.aZq;
        if (cdVar.getListView() != null) {
            cdVar2 = this.bjp.aZq;
            if (cdVar2.getListView().getChildAt(0) != null) {
                o.a aVar = new o.a();
                cdVar3 = this.bjp.aZq;
                aVar.asj = cdVar3.getListView().getFirstVisiblePosition();
                cdVar4 = this.bjp.aZq;
                aVar.top = cdVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bjp.bgT;
                ac = this.bjp.ac(i, i2);
                sparseArray.put(ac, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
    }
}
