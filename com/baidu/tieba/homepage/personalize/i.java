package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements aa.c {
    final /* synthetic */ a cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.cxb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.c
    public void aN(boolean z) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        nVar = this.cxb.cwT;
        if (nVar != null) {
            nVar2 = this.cxb.cwT;
            if (nVar2.JX() != null) {
                nVar4 = this.cxb.cwT;
                nVar4.JX().amY();
            }
            nVar3 = this.cxb.cwT;
            nVar3.fg(false);
        }
    }
}
