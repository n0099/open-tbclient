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
            MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
            aVar.customGroupType = 1;
            aVar.id = valueOf;
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
        }
    }
}
