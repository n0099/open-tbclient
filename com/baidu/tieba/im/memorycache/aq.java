package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao ddE;
    private final /* synthetic */ ImMessageCenterPojo ddF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ddE = aoVar;
        this.ddF = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.j.aox().c(this.ddF);
        return null;
    }
}
