package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class u implements CustomMessageTask.CustomRunnable<com.baidu.tieba.tbadkCore.b.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.tbadkCore.b.a> customMessage) {
        return new CustomResponsedMessage<>(2001329, new k());
    }
}
