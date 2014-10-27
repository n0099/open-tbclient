package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeValidateActivityIsOpenConfig;
import com.baidu.tieba.im.validate.ValidateActivity;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<InvokeValidateActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<InvokeValidateActivityIsOpenConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2008004, Boolean.valueOf(ValidateActivity.isOpen));
    }
}
