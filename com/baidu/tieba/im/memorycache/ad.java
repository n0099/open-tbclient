package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ac ddX;
    private final /* synthetic */ ImMessageCenterPojo ddY;
    private final /* synthetic */ ImMessageCenterPojo ddd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.ddX = acVar;
        this.ddd = imMessageCenterPojo;
        this.ddY = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.j.aqE().a(this.ddd, 2);
        if (this.ddY != null) {
            com.baidu.tieba.im.db.j.aqE().a(this.ddY, 2);
            return null;
        }
        return null;
    }
}
