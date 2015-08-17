package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* loaded from: classes.dex */
class af implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
    final /* synthetic */ ae bAI;
    private final /* synthetic */ ImMessageCenterPojo bzR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAI = aeVar;
        this.bzR = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.db.i.Te().a(this.bzR);
        }
        return null;
    }
}
