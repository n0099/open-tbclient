package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bc implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo cmS;
    final /* synthetic */ bb cnZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnZ = bbVar;
        this.cmS = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.aex().a(this.cmS, 1);
        return null;
    }
}
