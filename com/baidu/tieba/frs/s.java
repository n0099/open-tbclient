package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FrsActivity frsActivity, int i) {
        super(i);
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (updateAttentionMessage.getData().sZ) {
                    if (updateAttentionMessage.isAttention()) {
                        this.bhl.showToast(t.j.like_success);
                    }
                    this.bhl.a(updateAttentionMessage);
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.bhl.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
