package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long ayf;
    final /* synthetic */ as bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.bky = asVar;
        this.ayf = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Qb().Qc();
            com.baidu.tieba.im.db.k.Qg().y(String.valueOf(this.ayf), 2);
            com.baidu.tieba.im.db.n.Qm().gs(String.valueOf(this.ayf));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Qb().endTransaction();
        }
    }
}
