package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* loaded from: classes.dex */
class ag implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
    final /* synthetic */ af ddZ;
    private final /* synthetic */ ImMessageCenterPojo ddd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ddZ = afVar;
        this.ddd = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.db.j.aqE().c(this.ddd);
        }
        return null;
    }
}
