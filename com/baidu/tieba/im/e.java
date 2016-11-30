package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.util.f<Integer> {
    final /* synthetic */ c cZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cZb = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: e */
    public void onReturnDataInUI(Integer num) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
    }
}
