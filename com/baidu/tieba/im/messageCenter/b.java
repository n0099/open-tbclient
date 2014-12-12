package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeUpdateActivityIsOpenConfig;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<InvokeUpdateActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<InvokeUpdateActivityIsOpenConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008005, Boolean.valueOf(ChatStatusManager.getInst().getIsOpen(6)));
    }
}
