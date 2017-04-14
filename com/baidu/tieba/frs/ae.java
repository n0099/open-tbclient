package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.bNJ = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.g.u uVar;
        com.baidu.tieba.frs.g.u uVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bNJ.bME != null && this.bNJ.bME.aJw() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bNJ.bME.aJw().getId())) {
                this.bNJ.bME.d(signData);
                uVar = this.bNJ.bMP;
                uVar.j(this.bNJ.bME);
                int user_level = this.bNJ.bME.aJw().getUser_level();
                uVar2 = this.bNJ.bMP;
                if (uVar2.adZ()) {
                    user_level = this.bNJ.bME.aJw().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bNJ.bME.aJw().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
