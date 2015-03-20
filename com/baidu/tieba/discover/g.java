package com.baidu.tieba.discover;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        if (customMessage != null) {
            a.aBv = true;
            return new CustomResponsedMessage<>(2012119);
        }
        return null;
    }
}
