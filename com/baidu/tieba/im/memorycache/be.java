package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class be implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bd bhJ;
    private final /* synthetic */ ImMessageCenterPojo bhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhJ = bdVar;
        this.bhq = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.k.MD().a(this.bhq, 2);
        }
        return null;
    }
}
