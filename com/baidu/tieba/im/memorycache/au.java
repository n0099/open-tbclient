package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long axX;
    final /* synthetic */ as bki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.bki = asVar;
        this.axX = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.PO().PP();
            com.baidu.tieba.im.db.k.PT().y(String.valueOf(this.axX), 2);
            com.baidu.tieba.im.db.n.PZ().gp(String.valueOf(this.axX));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.PO().endTransaction();
        }
    }
}
