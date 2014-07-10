package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.ac> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.atomData.ac> run(CustomMessage<com.baidu.tbadk.core.atomData.ac> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            ai.c().f();
        }
        return null;
    }
}
