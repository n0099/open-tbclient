package com.baidu.tieba.frs.h5;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.df;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof df)) {
            df dfVar = (df) customResponsedMessage.getData();
            i iVar = new i();
            iVar.setTag(dfVar.aTm);
            dfVar.a(100, iVar);
        }
    }
}
