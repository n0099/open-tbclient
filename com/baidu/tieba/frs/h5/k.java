package com.baidu.tieba.frs.h5;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.bz;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof bz)) {
            bz bzVar = (bz) customResponsedMessage.getData();
            i iVar = new i();
            iVar.setTag(bzVar.bcf);
            bzVar.a(100, iVar);
        }
    }
}
