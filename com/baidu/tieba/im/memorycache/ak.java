package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ak implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo dbA;
    final /* synthetic */ aj dbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dbI = ajVar;
        this.dbA = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.apy().apz();
                com.baidu.tieba.im.db.j.apD().c(this.dbA);
                com.baidu.tieba.im.db.c.apu().km(this.dbA.getGid());
                com.baidu.tieba.im.db.g.apy().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.apy().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.apy().endTransaction();
            throw th;
        }
    }
}
