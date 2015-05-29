package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long azQ;
    final /* synthetic */ as bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.bnc = asVar;
        this.azQ = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Rq().Rr();
            com.baidu.tieba.im.db.k.Rv().y(String.valueOf(this.azQ), 2);
            com.baidu.tieba.im.db.n.RB().gU(String.valueOf(this.azQ));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Rq().endTransaction();
        }
    }
}
