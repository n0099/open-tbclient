package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            String data = customMessage.getData();
            if (!TextUtils.isEmpty(data)) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new com.baidu.tieba.im.message.h(data, 4, false)));
            }
        }
        return null;
    }
}
