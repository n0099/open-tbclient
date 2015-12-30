package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements eu {
    final /* synthetic */ o bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bng = oVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        cg cgVar;
        cg cgVar2;
        cg cgVar3;
        cg cgVar4;
        SparseArray sparseArray;
        int ac;
        cgVar = this.bng.bdm;
        if (cgVar.getListView() != null) {
            cgVar2 = this.bng.bdm;
            if (cgVar2.getListView().getChildAt(0) != null) {
                o.a aVar = new o.a();
                cgVar3 = this.bng.bdm;
                aVar.atN = cgVar3.getListView().getFirstVisiblePosition();
                cgVar4 = this.bng.bdm;
                aVar.top = cgVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bng.bkK;
                ac = this.bng.ac(i, i2);
                sparseArray.put(ac, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
    }
}
