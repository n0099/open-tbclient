package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bXL;
    final /* synthetic */ as bXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bXZ = asVar;
        this.bXL = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Yr().c(this.bXL);
        return null;
    }
}
