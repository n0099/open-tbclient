package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ab.c {
    final /* synthetic */ a czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.czr = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aO(boolean z) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        nVar = this.czr.czj;
        if (nVar != null) {
            nVar2 = this.czr.czj;
            if (nVar2.Lc() != null) {
                nVar4 = this.czr.czj;
                nVar4.Lc().amG();
            }
            nVar3 = this.czr.czj;
            nVar3.fh(false);
        }
    }
}
