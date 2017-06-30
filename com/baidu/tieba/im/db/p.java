package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.util.h<Void> {
    final /* synthetic */ n dcZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.dcZ = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    /* renamed from: c */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_CLEAR_MSG));
    }
}
