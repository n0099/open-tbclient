package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* loaded from: classes.dex */
class af implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
    private final /* synthetic */ ImMessageCenterPojo bDL;
    final /* synthetic */ ae bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bED = aeVar;
        this.bDL = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.db.i.TK().c(this.bDL);
        }
        return null;
    }
}
