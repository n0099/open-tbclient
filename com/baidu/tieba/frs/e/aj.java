package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ca;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ae.c {
    final /* synthetic */ ag cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.cbR = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aN(boolean z) {
        at atVar;
        ca caVar;
        u uVar;
        at atVar2;
        com.baidu.tieba.frs.r rVar;
        at atVar3;
        at atVar4;
        atVar = this.cbR.bOn;
        if (atVar != null) {
            caVar = this.cbR.bYD;
            if (caVar != null) {
                uVar = this.cbR.bOx;
                if (uVar != null) {
                    atVar2 = this.cbR.bOn;
                    if (atVar2 != null) {
                        atVar3 = this.cbR.bOn;
                        if (atVar3.Kq() != null) {
                            atVar4 = this.cbR.bOn;
                            atVar4.Kq().ajv();
                        }
                    }
                    rVar = this.cbR.bNK;
                    rVar.dL(false);
                    com.baidu.adp.lib.g.h.fS().postDelayed(new ak(this), 110L);
                }
            }
        }
    }
}
