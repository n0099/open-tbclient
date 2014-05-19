package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeLiveNotifyActivityIsOpenConfig;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<InvokeLiveNotifyActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<InvokeLiveNotifyActivityIsOpenConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2010018, Boolean.valueOf(LiveNotifyActivity.a));
    }
}
