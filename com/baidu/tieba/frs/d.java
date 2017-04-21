package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.bQa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage.getCmd() == 2016495) {
            Object data = customResponsedMessage.getData();
            if (data instanceof com.baidu.tbadk.core.data.bi) {
                com.baidu.tieba.frs.f.s.a(this.bQa.bOU, this.bQa.bOV, this.bQa.getForumId(), true, (com.baidu.tbadk.core.data.bi) data);
            }
        }
    }
}
