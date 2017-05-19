package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ac cXX;
    private final /* synthetic */ ImMessageCenterPojo cXY;
    private final /* synthetic */ ImMessageCenterPojo cXe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.cXX = acVar;
        this.cXe = imMessageCenterPojo;
        this.cXY = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.j.anx().a(this.cXe, 2);
        if (this.cXY != null) {
            com.baidu.tieba.im.db.j.anx().a(this.cXY, 2);
            return null;
        }
        return null;
    }
}
