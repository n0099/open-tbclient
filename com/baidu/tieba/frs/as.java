package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class as extends CustomMessageListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(FrsActivity frsActivity, int i) {
        super(i);
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.frs.h.m mVar;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.frs.h.m mVar2;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.tbadkCore.o oVar8;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            oVar = this.bhl.bgq;
            if (oVar != null) {
                oVar2 = this.bhl.bgq;
                if (oVar2.avD() != null) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (signData.getForumId() != null) {
                        String forumId = signData.getForumId();
                        oVar3 = this.bhl.bgq;
                        if (forumId.equals(oVar3.avD().getId())) {
                            oVar4 = this.bhl.bgq;
                            oVar4.d(signData);
                            mVar = this.bhl.bgE;
                            oVar5 = this.bhl.bgq;
                            mVar.f(oVar5);
                            oVar6 = this.bhl.bgq;
                            int user_level = oVar6.avD().getUser_level();
                            mVar2 = this.bhl.bgE;
                            if (mVar2.TV()) {
                                oVar8 = this.bhl.bgq;
                                user_level = oVar8.avD().getUser_level() + 1;
                            }
                            TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                            oVar7 = this.bhl.bgq;
                            m11getInst.addSignedForum(oVar7.avD().getName(), signData.getBonusPoint(), user_level);
                        }
                    }
                }
            }
        }
    }
}
