package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements fe {
    final /* synthetic */ o bpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bpV = oVar;
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        SparseArray sparseArray;
        int ac;
        cnVar = this.bpV.bfD;
        if (cnVar.KM() != null) {
            cnVar2 = this.bpV.bfD;
            if (cnVar2.KM().getChildAt(0) != null) {
                o.a aVar = new o.a();
                cnVar3 = this.bpV.bfD;
                aVar.auF = cnVar3.KM().getFirstVisiblePosition();
                cnVar4 = this.bpV.bfD;
                aVar.top = cnVar4.KM().getChildAt(0).getTop();
                sparseArray = this.bpV.bnH;
                ac = this.bpV.ac(i, i2);
                sparseArray.put(ac, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
    }
}
