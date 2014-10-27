package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p aVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aVo = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008016));
    }
}
