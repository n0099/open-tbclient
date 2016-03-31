package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(FrsActivity frsActivity, int i) {
        super(i);
        this.blk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.tbadkCore.o oVar8;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            oVar = this.blk.bkq;
            if (oVar != null) {
                oVar2 = this.blk.bkq;
                if (oVar2.avu() != null) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (signData.getForumId() != null) {
                        String forumId = signData.getForumId();
                        oVar3 = this.blk.bkq;
                        if (forumId.equals(oVar3.avu().getId())) {
                            oVar4 = this.blk.bkq;
                            oVar4.d(signData);
                            aVar = this.blk.bkD;
                            oVar5 = this.blk.bkq;
                            aVar.e(oVar5);
                            oVar6 = this.blk.bkq;
                            int user_level = oVar6.avu().getUser_level();
                            aVar2 = this.blk.bkD;
                            if (aVar2.TM()) {
                                oVar8 = this.blk.bkq;
                                user_level = oVar8.avu().getUser_level() + 1;
                            }
                            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                            oVar7 = this.blk.bkq;
                            m411getInst.addSignedForum(oVar7.avu().getName(), signData.getBonusPoint(), user_level);
                        }
                    }
                }
            }
        }
    }
}
