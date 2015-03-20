package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        return new CustomResponsedMessage<>(2001293, Integer.valueOf(u.icon_new_trends));
    }
}
