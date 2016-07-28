package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(FrsActivity frsActivity, int i) {
        super(i);
        this.bEL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.j.p pVar;
        com.baidu.tieba.frs.j.p pVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bEL.bDM != null && this.bEL.bDM.aGX() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bEL.bDM.aGX().getId())) {
                this.bEL.bDM.d(signData);
                pVar = this.bEL.bDY;
                pVar.g(this.bEL.bDM);
                int user_level = this.bEL.bDM.aGX().getUser_level();
                pVar2 = this.bEL.bDY;
                if (pVar2.aaO()) {
                    user_level = this.bEL.bDM.aGX().getUser_level() + 1;
                }
                TbadkCoreApplication.m10getInst().addSignedForum(this.bEL.bDM.aGX().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
