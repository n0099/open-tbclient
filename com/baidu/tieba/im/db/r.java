package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ p aWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aWU = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008016));
    }
}
