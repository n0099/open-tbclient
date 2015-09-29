package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ea {
    final /* synthetic */ o bbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bbU = oVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        SparseArray sparseArray;
        int Y;
        bsVar = this.bbU.aTJ;
        if (bsVar.getListView() != null) {
            bsVar2 = this.bbU.aTJ;
            if (bsVar2.getListView().getChildAt(0) != null) {
                o.a aVar = new o.a();
                bsVar3 = this.bbU.aTJ;
                aVar.bbW = bsVar3.getListView().getFirstVisiblePosition();
                bsVar4 = this.bbU.aTJ;
                aVar.top = bsVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bbU.aZW;
                Y = this.bbU.Y(i, i2);
                sparseArray.put(Y, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
