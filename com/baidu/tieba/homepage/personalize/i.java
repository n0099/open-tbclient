package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements z.c {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.cKG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.c
    public void aM(boolean z) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        nVar = this.cKG.cKz;
        if (nVar != null) {
            nVar2 = this.cKG.cKz;
            if (nVar2.Kp() != null) {
                nVar4 = this.cKG.cKz;
                nVar4.Kp().aro();
            }
            nVar3 = this.cKG.cKz;
            nVar3.fr(false);
        }
    }
}
