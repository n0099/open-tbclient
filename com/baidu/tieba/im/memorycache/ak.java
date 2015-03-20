package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ak implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bjW;
    final /* synthetic */ aj bkd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkd = ajVar;
        this.bjW = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.PO().PP();
                com.baidu.tieba.im.db.k.PT().a(this.bjW);
                com.baidu.tieba.im.db.c.PK().gr(this.bjW.getGid());
                com.baidu.tieba.im.db.g.PO().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.PO().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.PO().endTransaction();
            throw th;
        }
    }
}
