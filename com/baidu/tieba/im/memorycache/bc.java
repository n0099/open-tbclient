package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bc implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo clU;
    final /* synthetic */ bb cnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnc = bbVar;
        this.clU = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.aey().a(this.clU, 1);
        return null;
    }
}
