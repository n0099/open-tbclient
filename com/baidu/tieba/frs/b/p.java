package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ec {
    final /* synthetic */ o bcK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bcK = oVar;
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        SparseArray sparseArray;
        int aa;
        bsVar = this.bcK.aUc;
        if (bsVar.getListView() != null) {
            bsVar2 = this.bcK.aUc;
            if (bsVar2.getListView().getChildAt(0) != null) {
                o.a aVar = new o.a();
                bsVar3 = this.bcK.aUc;
                aVar.bcM = bsVar3.getListView().getFirstVisiblePosition();
                bsVar4 = this.bcK.aUc;
                aVar.top = bsVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bcK.baB;
                aa = this.bcK.aa(i, i2);
                sparseArray.put(aa, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
    }
}
