package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ao implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bEI;
    private final /* synthetic */ ImMessageCenterPojo bEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEI = anVar;
        this.bEJ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.TK().c(this.bEJ);
        return null;
    }
}
