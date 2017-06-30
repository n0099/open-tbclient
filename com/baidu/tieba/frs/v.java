package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.cdl = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        UserData userData;
        com.baidu.tieba.frs.f.m mVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.cdl.cbN != null && (userData = this.cdl.cbN.getUserData()) != null) {
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                mVar = this.cdl.cct;
                mVar.e(num);
            }
        }
    }
}
