package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ao implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bEx;
    private final /* synthetic */ ImMessageCenterPojo bEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEx = anVar;
        this.bEy = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.TO().c(this.bEy);
        return null;
    }
}
