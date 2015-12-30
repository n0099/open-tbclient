package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao bXW;
    private final /* synthetic */ ImMessageCenterPojo bXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bXW = aoVar;
        this.bXX = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Yr().c(this.bXX);
        return null;
    }
}
