package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ab.c {
    final /* synthetic */ a cyA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.cyA = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aM(boolean z) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        nVar = this.cyA.cys;
        if (nVar != null) {
            nVar2 = this.cyA.cys;
            if (nVar2.KC() != null) {
                nVar4 = this.cyA.cys;
                nVar4.KC().alL();
            }
            nVar3 = this.cyA.cys;
            nVar3.eX(false);
        }
    }
}
