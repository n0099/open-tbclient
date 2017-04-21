package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.bQa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.g.u uVar;
        com.baidu.tieba.frs.g.u uVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bQa.bOV != null && this.bQa.bOV.aKx() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bQa.bOV.aKx().getId())) {
                this.bQa.bOV.d(signData);
                uVar = this.bQa.bPg;
                uVar.j(this.bQa.bOV);
                int user_level = this.bQa.bOV.aKx().getUser_level();
                uVar2 = this.bQa.bPg;
                if (uVar2.afa()) {
                    user_level = this.bQa.bOV.aKx().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bQa.bOV.aKx().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
