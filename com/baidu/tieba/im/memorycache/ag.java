package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ag implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.h> {
    private final /* synthetic */ ImMessageCenterPojo bjk;
    final /* synthetic */ af bkb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkb = afVar;
        this.bjk = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.h> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.db.k.PT().a(this.bjk);
        }
        return null;
    }
}
