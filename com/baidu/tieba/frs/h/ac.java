package com.baidu.tieba.frs.h;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ ab buI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.buI = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar;
        cn cnVar;
        aa aaVar2;
        FrsActivity frsActivity;
        aaVar = this.buI.buH;
        cnVar = aaVar.bgo;
        if (cnVar.PA()) {
            aaVar2 = this.buI.buH;
            frsActivity = aaVar2.bpj;
            frsActivity.Pp();
        }
    }
}
