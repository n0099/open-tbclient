package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo dbA;
    final /* synthetic */ ax dbQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dbQ = axVar;
        this.dbA = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.apy().apz();
            com.baidu.tieba.im.db.j.apD().c(this.dbA);
            if (this.dbA.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.apu().km(this.dbA.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.apy().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.dbA);
    }
}
