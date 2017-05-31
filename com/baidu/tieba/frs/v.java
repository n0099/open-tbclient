package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r rVar, int i) {
        super(i);
        this.bVb = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        UserData userData;
        com.baidu.tieba.frs.f.u uVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.bVb.bTF != null && (userData = this.bVb.bTF.getUserData()) != null) {
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                uVar = this.bVb.bUk;
                uVar.a(num);
            }
        }
    }
}
