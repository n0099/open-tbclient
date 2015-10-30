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
    final /* synthetic */ o bcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bcf = oVar;
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
        bsVar = this.bcf.aTU;
        if (bsVar.getListView() != null) {
            bsVar2 = this.bcf.aTU;
            if (bsVar2.getListView().getChildAt(0) != null) {
                o.a aVar = new o.a();
                bsVar3 = this.bcf.aTU;
                aVar.bch = bsVar3.getListView().getFirstVisiblePosition();
                bsVar4 = this.bcf.aTU;
                aVar.top = bsVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bcf.bah;
                Y = this.bcf.Y(i, i2);
                sparseArray.put(Y, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Kq() {
    }
}
