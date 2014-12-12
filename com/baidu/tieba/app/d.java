package com.baidu.tieba.app;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.AppUploadMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof AppUploadMessage) {
            long appUploadDate = TbadkApplication.getInst().getAppUploadDate();
            if (appUploadDate + TbConfig.APP_OVERDUR_DRAFT_BOX < System.currentTimeMillis()) {
                AppInfoUploadService.startService(TbadkCoreApplication.getCurrentAccount());
            }
        }
    }
}
