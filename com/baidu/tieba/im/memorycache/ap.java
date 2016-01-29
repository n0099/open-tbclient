package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ap implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao ccq;
    private final /* synthetic */ ImMessageCenterPojo ccr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ccq = aoVar;
        this.ccr = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.abc().c(this.ccr);
        return null;
    }
}
