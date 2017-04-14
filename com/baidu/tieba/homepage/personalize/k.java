package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ab.a {
    final /* synthetic */ a cxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cxa = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.a
    public void B(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.cxa.cwS;
        if (nVar != null) {
            nVar2 = this.cxa.cwS;
            nVar2.eX(true);
            nVar3 = this.cxa.cwS;
            nVar3.ajm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
