package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.bNU = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.u uVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bNU.bMO != null && this.bNU.bMO.aJp() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bNU.bMO.aJp().getId())) {
                this.bNU.bMO.d(signData);
                uVar = this.bNU.bMZ;
                uVar.j(this.bNU.bMO);
                int user_level = this.bNU.bMO.aJp().getUser_level();
                uVar2 = this.bNU.bMZ;
                if (uVar2.aee()) {
                    user_level = this.bNU.bMO.aJp().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bNU.bMO.aJp().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
