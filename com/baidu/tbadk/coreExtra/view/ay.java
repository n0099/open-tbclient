package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ay extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.j) && ((com.baidu.tbadk.core.data.j) customResponsedMessage.getData()).info.contains("java.lang.SecurityException: No permission to modify given thread")) {
            TbadkCoreApplication.m411getInst().setWebviewCrashCount(TbadkCoreApplication.m411getInst().getWebviewCrashCount() + 1);
        }
    }
}
