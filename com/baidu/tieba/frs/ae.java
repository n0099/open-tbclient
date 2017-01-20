package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.bGL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.u uVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bGL.bFG != null && this.bGL.bFG.aJY() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bGL.bFG.aJY().getId())) {
                this.bGL.bFG.d(signData);
                uVar = this.bGL.bFR;
                uVar.j(this.bGL.bFG);
                int user_level = this.bGL.bFG.aJY().getUser_level();
                uVar2 = this.bGL.bFR;
                if (uVar2.ade()) {
                    user_level = this.bGL.bFG.aJY().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bGL.bFG.aJY().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
