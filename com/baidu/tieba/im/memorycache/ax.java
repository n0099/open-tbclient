package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ax implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw bhF;
    private final /* synthetic */ ImMessageCenterPojo bhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhF = awVar;
        this.bhq = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.MD().a(this.bhq);
        return null;
    }
}
