package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FrsGoodActivity frsGoodActivity, int i) {
        super(i);
        this.bsj = frsGoodActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (updateAttentionMessage.getData().CK) {
                    if (updateAttentionMessage.isAttention()) {
                        this.bsj.showToast(t.j.like_success);
                    }
                    this.bsj.a(updateAttentionMessage);
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.bsj.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
