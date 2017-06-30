package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.cc;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ aa cqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cqg = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        av avVar;
        x xVar2;
        cc ccVar;
        x xVar3;
        av avVar2;
        x xVar4;
        cc ccVar2;
        xVar = this.cqg.cqf;
        avVar = xVar.ccj;
        if (avVar.aep() != null) {
            xVar2 = this.cqg.cqf;
            ccVar = xVar2.cne;
            if (ccVar != null) {
                xVar3 = this.cqg.cqf;
                avVar2 = xVar3.ccj;
                if (avVar2.aep().getVisibility() != 0) {
                    xVar4 = this.cqg.cqf;
                    ccVar2 = xVar4.cne;
                    ccVar2.GP();
                }
            }
        }
    }
}
