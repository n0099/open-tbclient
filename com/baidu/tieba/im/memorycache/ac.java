package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ac implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bDL;
    final /* synthetic */ ab bEB;
    private final /* synthetic */ ImMessageCenterPojo bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.bEB = abVar;
        this.bDL = imMessageCenterPojo;
        this.bEC = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.TO().a(this.bDL, 2);
        if (this.bEC != null) {
            com.baidu.tieba.im.db.i.TO().a(this.bEC, 2);
            return null;
        }
        return null;
    }
}
