package com.baidu.tieba.frs.j;

import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ch;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ ab ckn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.ckn = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        au auVar;
        y yVar2;
        ch chVar;
        y yVar3;
        au auVar2;
        y yVar4;
        ch chVar2;
        yVar = this.ckn.ckm;
        auVar = yVar.bRW;
        if (auVar.acH() != null) {
            yVar2 = this.ckn.ckm;
            chVar = yVar2.cgK;
            if (chVar != null) {
                yVar3 = this.ckn.ckm;
                auVar2 = yVar3.bRW;
                if (auVar2.acH().getVisibility() != 0) {
                    yVar4 = this.ckn.ckm;
                    chVar2 = yVar4.cgK;
                    chVar2.aaa();
                }
            }
        }
    }
}
