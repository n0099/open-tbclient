package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements t.a {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.crd = sVar;
    }

    @Override // com.baidu.tbadk.core.view.t.a
    public void E(View view) {
        a aVar;
        a aVar2;
        a aVar3;
        aVar = this.crd.cqY;
        if (aVar != null) {
            aVar2 = this.crd.cqY;
            aVar2.eE(true);
            aVar3 = this.crd.cqY;
            aVar3.agQ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
