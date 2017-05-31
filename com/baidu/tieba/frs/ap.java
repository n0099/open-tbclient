package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(r rVar, int i) {
        super(i);
        this.bVb = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.u uVar2;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bVb.bTF != null && this.bVb.bTF.aIz() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = this.bVb.bTF.aIz().getUser_level();
            if (signData.forumId != null && signData.forumId.equals(this.bVb.bTF.aIz().getId())) {
                this.bVb.bTF.d(signData);
                uVar = this.bVb.bUk;
                uVar.g(this.bVb.bTF);
                uVar2 = this.bVb.bUk;
                if (uVar2.aec()) {
                    i = this.bVb.bTF.aIz().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bVb.bTF.aIz().getName(), signData.sign_bonus_point, i);
            }
        }
    }
}
