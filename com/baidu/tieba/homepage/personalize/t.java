package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ae.c {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aM(boolean z) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        xVar = this.cIQ.cIH;
        if (xVar != null) {
            xVar2 = this.cIQ.cIH;
            if (xVar2.aes() != null) {
                xVar4 = this.cIQ.cIH;
                xVar4.aes().aog();
            }
            xVar3 = this.cIQ.cIH;
            xVar3.ft(false);
        }
    }
}
