package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar bEL;
    private final /* synthetic */ ImMessageCenterPojo bEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEL = arVar;
        this.bEx = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.TK().c(this.bEx);
        return null;
    }
}
