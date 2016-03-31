package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements fo {
    final /* synthetic */ o buW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.buW = oVar;
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        SparseArray sparseArray;
        int Z;
        csVar = this.buW.bko;
        if (csVar.Mg() != null) {
            csVar2 = this.buW.bko;
            if (csVar2.Mg().getChildAt(0) != null) {
                o.a aVar = new o.a();
                csVar3 = this.buW.bko;
                aVar.avf = csVar3.Mg().getFirstVisiblePosition();
                csVar4 = this.buW.bko;
                aVar.top = csVar4.Mg().getChildAt(0).getTop();
                sparseArray = this.buW.bsE;
                Z = this.buW.Z(i, i2);
                sparseArray.put(Z, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
    }
}
