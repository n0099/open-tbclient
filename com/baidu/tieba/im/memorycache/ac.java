package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ac implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bTm;
    final /* synthetic */ ab bUd;
    private final /* synthetic */ ImMessageCenterPojo bUe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.bUd = abVar;
        this.bTm = imMessageCenterPojo;
        this.bUe = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Xl().a(this.bTm, 2);
        if (this.bUe != null) {
            com.baidu.tieba.im.db.i.Xl().a(this.bUe, 2);
            return null;
        }
        return null;
    }
}
