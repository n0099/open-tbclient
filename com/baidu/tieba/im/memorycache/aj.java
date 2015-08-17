package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aj implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bAD;
    final /* synthetic */ ai bAK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAK = aiVar;
        this.bAD = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.SZ().Ta();
                com.baidu.tieba.im.db.i.Te().a(this.bAD);
                com.baidu.tieba.im.db.c.SV().hw(this.bAD.getGid());
                com.baidu.tieba.im.db.g.SZ().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.SZ().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.SZ().endTransaction();
            throw th;
        }
    }
}
