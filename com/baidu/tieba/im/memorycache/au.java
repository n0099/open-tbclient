package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long azR;
    final /* synthetic */ as bnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.bnd = asVar;
        this.azR = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Rr().Rs();
            com.baidu.tieba.im.db.k.Rw().y(String.valueOf(this.azR), 2);
            com.baidu.tieba.im.db.n.RC().gU(String.valueOf(this.azR));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Rr().endTransaction();
        }
    }
}
