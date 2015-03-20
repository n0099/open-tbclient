package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDismissGroupMessage) && socketResponsedMessage.getError() == 0) {
            String valueOf = String.valueOf(((ResponseDismissGroupMessage) socketResponsedMessage).getGroupId());
            com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
            fVar.customGroupType = 1;
            fVar.id = valueOf;
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(fVar));
        }
    }
}
