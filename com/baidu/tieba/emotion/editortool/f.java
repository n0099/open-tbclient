package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.EMOTION_IS_VALID, Boolean.valueOf(x.Xm().fu(customMessage.getData())));
    }
}
