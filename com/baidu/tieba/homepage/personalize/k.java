package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements aa.a {
    final /* synthetic */ a cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cxb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.a
    public void D(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.cxb.cwT;
        if (nVar != null) {
            nVar2 = this.cxb.cwT;
            nVar2.fg(true);
            nVar3 = this.cxb.cwT;
            nVar3.akg();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
