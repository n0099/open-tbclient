package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ae.c {
    final /* synthetic */ x cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.cqf = xVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aM(boolean z) {
        av avVar;
        cc ccVar;
        m mVar;
        av avVar2;
        com.baidu.tieba.frs.r rVar;
        av avVar3;
        av avVar4;
        avVar = this.cqf.ccj;
        if (avVar != null) {
            ccVar = this.cqf.cne;
            if (ccVar != null) {
                mVar = this.cqf.cct;
                if (mVar != null) {
                    avVar2 = this.cqf.ccj;
                    if (avVar2 != null) {
                        avVar3 = this.cqf.ccj;
                        if (avVar3.aes() != null) {
                            avVar4 = this.cqf.ccj;
                            avVar4.aes().aog();
                        }
                    }
                    rVar = this.cqf.cbE;
                    rVar.et(false);
                    com.baidu.adp.lib.g.h.fR().postDelayed(new ab(this), 110L);
                }
            }
        }
    }
}
