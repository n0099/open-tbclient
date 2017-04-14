package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo daL;
    final /* synthetic */ ac dbE;
    private final /* synthetic */ ImMessageCenterPojo dbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.dbE = acVar;
        this.daL = imMessageCenterPojo;
        this.dbF = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.j.apD().a(this.daL, 2);
        if (this.dbF != null) {
            com.baidu.tieba.im.db.j.apD().a(this.dbF, 2);
            return null;
        }
        return null;
    }
}
