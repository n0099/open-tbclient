package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class y extends CustomMessageListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(FrsActivity frsActivity, int i) {
        super(i);
        this.bTa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.j.n nVar;
        com.baidu.tieba.frs.j.n nVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bTa.bRX != null && this.bTa.bRX.aOk() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bTa.bRX.aOk().getId())) {
                this.bTa.bRX.d(signData);
                nVar = this.bTa.bSi;
                nVar.k(this.bTa.bRX);
                int user_level = this.bTa.bRX.aOk().getUser_level();
                nVar2 = this.bTa.bSi;
                if (nVar2.ahA()) {
                    user_level = this.bTa.bRX.aOk().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bTa.bRX.aOk().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
