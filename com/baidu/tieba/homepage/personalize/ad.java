package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements t.d {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.ctN = zVar;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aI(boolean z) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        bVar = this.ctN.ctI;
        if (bVar != null) {
            bVar2 = this.ctN.ctI;
            if (bVar2.Ij() != null) {
                bVar4 = this.ctN.ctI;
                bVar4.Ij().aWB();
            }
            bVar3 = this.ctN.ctI;
            bVar3.eF(false);
        }
    }
}
