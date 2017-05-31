package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ae.c {
    final /* synthetic */ ag cif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.cif = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aL(boolean z) {
        au auVar;
        cb cbVar;
        u uVar;
        au auVar2;
        com.baidu.tieba.frs.r rVar;
        au auVar3;
        au auVar4;
        auVar = this.cif.bUa;
        if (auVar != null) {
            cbVar = this.cif.ceP;
            if (cbVar != null) {
                uVar = this.cif.bUk;
                if (uVar != null) {
                    auVar2 = this.cif.bUa;
                    if (auVar2 != null) {
                        auVar3 = this.cif.bUa;
                        if (auVar3.aaC() != null) {
                            auVar4 = this.cif.bUa;
                            auVar4.aaC().akv();
                        }
                    }
                    rVar = this.cif.bTw;
                    rVar.eb(false);
                    com.baidu.adp.lib.g.h.fS().postDelayed(new ak(this), 110L);
                }
            }
        }
    }
}
