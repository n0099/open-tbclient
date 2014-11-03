package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aj implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.g> {
    private final /* synthetic */ ImMessageCenterPojo bdl;
    final /* synthetic */ ai beg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.beg = aiVar;
        this.bdl = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.g> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.db.k.MJ().a(this.bdl);
        }
        return null;
    }
}
