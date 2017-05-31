package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.util.g<Void> {
    final /* synthetic */ n cVc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cVc = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: c */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_CLEAR_MSG));
    }
}
