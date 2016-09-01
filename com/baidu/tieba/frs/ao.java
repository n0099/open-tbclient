package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(FrsActivity frsActivity, int i) {
        super(i);
        this.bQp = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bQp.bPq != null && this.bQp.bPq.aLP() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bQp.bPq.aLP().getId())) {
                this.bQp.bPq.d(signData);
                pVar = this.bQp.bPC;
                pVar.h(this.bQp.bPq);
                int user_level = this.bQp.bPq.aLP().getUser_level();
                pVar2 = this.bQp.bPC;
                if (pVar2.afz()) {
                    user_level = this.bQp.bPq.aLP().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bQp.bPq.aLP().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
