package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements z.c {
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.cqb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.c
    public void aN(boolean z) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        nVar = this.cqb.cpU;
        if (nVar != null) {
            nVar2 = this.cqb.cpU;
            if (nVar2.JI() != null) {
                nVar4 = this.cqb.cpU;
                nVar4.JI().alQ();
            }
            nVar3 = this.cqb.cpU;
            nVar3.fc(false);
        }
    }
}
