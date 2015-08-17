package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ac implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ab bAH;
    private final /* synthetic */ ImMessageCenterPojo bzR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAH = abVar;
        this.bzR = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Te().a(this.bzR, 2);
        return null;
    }
}
