package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof by)) {
            by byVar = (by) customResponsedMessage.getData();
            com.baidu.tieba.frs.b.i iVar = new com.baidu.tieba.frs.b.i();
            iVar.setTag(byVar.baI);
            byVar.a(100, iVar);
        }
    }
}
