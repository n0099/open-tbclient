package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(FrsActivity frsActivity, int i) {
        super(i);
        this.bQi = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bQi.bPk != null && this.bQi.bPk.aMr() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bQi.bPk.aMr().getId())) {
                this.bQi.bPk.d(signData);
                pVar = this.bQi.bPu;
                pVar.h(this.bQi.bPk);
                int user_level = this.bQi.bPk.aMr().getUser_level();
                pVar2 = this.bQi.bPu;
                if (pVar2.afN()) {
                    user_level = this.bQi.bPk.aMr().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bQi.bPk.aMr().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
