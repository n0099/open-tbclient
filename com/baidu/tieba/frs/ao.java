package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.frs.i.p pVar5;
        com.baidu.tieba.tbadkCore.p pVar6;
        com.baidu.tieba.tbadkCore.p pVar7;
        com.baidu.tieba.frs.i.p pVar8;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.tbadkCore.p pVar10;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            pVar = this.bDB.bCF;
            if (pVar != null) {
                pVar2 = this.bDB.bCF;
                if (pVar2.aDN() != null) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (signData.forumId != null) {
                        String str = signData.forumId;
                        pVar3 = this.bDB.bCF;
                        if (str.equals(pVar3.aDN().getId())) {
                            pVar4 = this.bDB.bCF;
                            pVar4.d(signData);
                            pVar5 = this.bDB.bCR;
                            pVar6 = this.bDB.bCF;
                            pVar5.g(pVar6);
                            pVar7 = this.bDB.bCF;
                            int user_level = pVar7.aDN().getUser_level();
                            pVar8 = this.bDB.bCR;
                            if (pVar8.aam()) {
                                pVar10 = this.bDB.bCF;
                                user_level = pVar10.aDN().getUser_level() + 1;
                            }
                            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                            pVar9 = this.bDB.bCF;
                            m9getInst.addSignedForum(pVar9.aDN().getName(), signData.sign_bonus_point, user_level);
                        }
                    }
                }
            }
        }
    }
}
