package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001332 && customResponsedMessage.getData() != null) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbadkCoreApplication.m411getInst().setIsKuangLogin(true);
                b.bA(true);
                return;
            }
            TbadkCoreApplication.m411getInst().setIsKuangLogin(false);
            MessageManager.getInstance().dispatchResponsedMessage(new ReLoginFromKuangMessage(false));
        }
    }
}
