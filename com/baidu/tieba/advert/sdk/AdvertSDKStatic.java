package com.baidu.tieba.advert.sdk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.SplashAd;
/* loaded from: classes7.dex */
public class AdvertSDKStatic {
    static {
        new a().registerTask();
        AdSettings.setSupportHttps(true);
        SplashAd.setMaxVideoCacheCapacityMb(30);
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionAppList(true);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.g.c>() { // from class: com.baidu.tieba.advert.sdk.AdvertSDKStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.g.c> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                com.baidu.tieba.advert.sdk.b.a.bMI().b(customMessage.getData());
                if (com.baidu.tieba.advert.sdk.b.a.bMI().bMK()) {
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_START_REQUEST_BES_AD, 1400L);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_START_REQUEST_BES_AD, 1000L);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(new CustomMessageTask(2016552, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.advert.sdk.AdvertSDKStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    com.baidu.tieba.advert.sdk.b.a.bMI().Fu(customMessage.getData());
                }
                return null;
            }
        }));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921533, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.g.c>() { // from class: com.baidu.tieba.advert.sdk.AdvertSDKStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.g.c> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    com.baidu.tieba.advert.sdk.b.a.bMI().a(customMessage.getData().bkt(), false);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
