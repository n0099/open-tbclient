package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.bTa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage.getCmd() == 2016495) {
            Object data = customResponsedMessage.getData();
            if (data instanceof com.baidu.tbadk.core.data.bk) {
                com.baidu.tieba.frs.utils.t.a(this.bTa.bRW, this.bTa.bRX, this.bTa.getForumId(), true, (com.baidu.tbadk.core.data.bk) data);
            }
        }
    }
}
