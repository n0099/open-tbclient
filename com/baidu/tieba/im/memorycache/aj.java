package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aj implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ai bEF;
    private final /* synthetic */ ImMessageCenterPojo bEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEF = aiVar;
        this.bEx = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.TF().TG();
                com.baidu.tieba.im.db.i.TK().c(this.bEx);
                com.baidu.tieba.im.db.c.TB().hJ(this.bEx.getGid());
                com.baidu.tieba.im.db.g.TF().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.TF().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.TF().endTransaction();
            throw th;
        }
    }
}
