package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.j) && ((com.baidu.tbadk.core.data.j) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
        }
    }
}
