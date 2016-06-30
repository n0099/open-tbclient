package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aNB;
    final /* synthetic */ as cTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.cTk = asVar;
        this.aNB = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.amK().amL();
            com.baidu.tieba.im.db.i.amO().ac(String.valueOf(this.aNB), 2);
            com.baidu.tieba.im.db.l.amU().kv(String.valueOf(this.aNB));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.amK().endTransaction();
        }
    }
}
