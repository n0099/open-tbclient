package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ab.a {
    final /* synthetic */ a czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.czr = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.a
    public void B(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.czr.czj;
        if (nVar != null) {
            nVar2 = this.czr.czj;
            nVar2.fh(true);
            nVar3 = this.czr.czj;
            nVar3.akn();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
