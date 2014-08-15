package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ac;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<ac> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ac> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ImMessageCenterActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
