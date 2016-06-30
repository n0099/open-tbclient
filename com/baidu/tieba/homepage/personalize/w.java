package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements t.d {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.crd = sVar;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aF(boolean z) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        aVar = this.crd.cqY;
        if (aVar != null) {
            aVar2 = this.crd.cqY;
            if (aVar2.Il() != null) {
                aVar4 = this.crd.cqY;
                aVar4.Il().aTy();
            }
            aVar3 = this.crd.cqY;
            aVar3.eE(false);
        }
    }
}
