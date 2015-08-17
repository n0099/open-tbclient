package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ao implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bAM;
    private final /* synthetic */ ImMessageCenterPojo bAN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAM = anVar;
        this.bAN = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Te().a(this.bAN);
        return null;
    }
}
