package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aj implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bES;
    final /* synthetic */ ai bFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFa = aiVar;
        this.bES = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.Ua().Ub();
                com.baidu.tieba.im.db.i.Uf().c(this.bES);
                com.baidu.tieba.im.db.c.TW().hL(this.bES.getGid());
                com.baidu.tieba.im.db.g.Ua().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.Ua().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.Ua().endTransaction();
            throw th;
        }
    }
}
