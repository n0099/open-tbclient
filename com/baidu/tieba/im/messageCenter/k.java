package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.InvokeLiveNotifyActivityIsOpenConfig;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<InvokeLiveNotifyActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<InvokeLiveNotifyActivityIsOpenConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008018, Boolean.valueOf(TbadkApplication.m251getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0).getBoolean("live_notify_page_showing", false)));
    }
}
