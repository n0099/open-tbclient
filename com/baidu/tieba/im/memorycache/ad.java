package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo dgM;
    final /* synthetic */ ac dhF;
    private final /* synthetic */ ImMessageCenterPojo dhG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.dhF = acVar;
        this.dgM = imMessageCenterPojo;
        this.dhG = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.aso().a(this.dgM, 2);
        if (this.dhG != null) {
            com.baidu.tieba.im.db.i.aso().a(this.dhG, 2);
            return null;
        }
        return null;
    }
}
