package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ac implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ab bEW;
    private final /* synthetic */ ImMessageCenterPojo bEX;
    private final /* synthetic */ ImMessageCenterPojo bEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.bEW = abVar;
        this.bEg = imMessageCenterPojo;
        this.bEX = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Uf().a(this.bEg, 2);
        if (this.bEX != null) {
            com.baidu.tieba.im.db.i.Uf().a(this.bEX, 2);
            return null;
        }
        return null;
    }
}
