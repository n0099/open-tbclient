package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aRB;
    final /* synthetic */ as dba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.dba = asVar;
        this.aRB = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aql().aqm();
            com.baidu.tieba.im.db.i.aqq().aa(String.valueOf(this.aRB), 2);
            com.baidu.tieba.im.db.l.aqw().kC(String.valueOf(this.aRB));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.aql().endTransaction();
        }
    }
}
