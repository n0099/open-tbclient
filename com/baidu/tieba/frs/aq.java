package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(r rVar, int i) {
        super(i);
        this.cdl = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.m mVar;
        com.baidu.tieba.frs.f.m mVar2;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.cdl.cbN != null && this.cdl.cbN.aMt() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = this.cdl.cbN.aMt().getUser_level();
            if (signData.forumId != null && signData.forumId.equals(this.cdl.cbN.aMt().getId())) {
                this.cdl.cbN.d(signData);
                mVar = this.cdl.cct;
                mVar.g(this.cdl.cbN);
                mVar2 = this.cdl.cct;
                if (mVar2.ahQ()) {
                    i = this.cdl.cbN.aMt().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.cdl.cbN.aMt().getName(), signData.sign_bonus_point, i);
            }
        }
    }
}
