package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aWK;
    final /* synthetic */ as doV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.doV = asVar;
        this.aWK = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.auF().auG();
            com.baidu.tieba.im.db.i.auK().ac(String.valueOf(this.aWK), 2);
            com.baidu.tieba.im.db.l.auQ().lL(String.valueOf(this.aWK));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.auF().endTransaction();
        }
    }
}
