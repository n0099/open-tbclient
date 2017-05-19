package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(r rVar, int i) {
        super(i);
        this.bPn = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.e.u uVar;
        com.baidu.tieba.frs.e.u uVar2;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bPn.bNT != null && this.bPn.bNT.aHE() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = this.bPn.bNT.aHE().getUser_level();
            if (signData.forumId != null && signData.forumId.equals(this.bPn.bNT.aHE().getId())) {
                this.bPn.bNT.d(signData);
                uVar = this.bPn.bOx;
                uVar.g(this.bPn.bNT);
                uVar2 = this.bPn.bOx;
                if (uVar2.acZ()) {
                    i = this.bPn.bNT.aHE().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bPn.bNT.aHE().getName(), signData.sign_bonus_point, i);
            }
        }
    }
}
