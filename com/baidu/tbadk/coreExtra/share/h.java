package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        d dVar;
        d dVar2;
        dVar = ShareStatic.adB;
        if (dVar != null) {
            dVar2 = ShareStatic.adB;
            dVar2.dismiss();
            ShareStatic.adB = null;
        }
        return null;
    }
}
