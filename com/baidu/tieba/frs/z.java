package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(FrsActivity frsActivity, int i) {
        super(i);
        this.bQi = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (!updateAttentionMessage.getData().vS) {
                    if (updateAttentionMessage.getData().errorString != null) {
                        this.bQi.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                this.bQi.c(updateAttentionMessage);
                this.bQi.b(updateAttentionMessage);
                this.bQi.a(updateAttentionMessage);
            }
        }
    }
}
