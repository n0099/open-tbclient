package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aTP;
    final /* synthetic */ as dhP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.dhP = asVar;
        this.aTP = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.asj().ask();
            com.baidu.tieba.im.db.i.aso().ac(String.valueOf(this.aTP), 2);
            com.baidu.tieba.im.db.l.asu().ll(String.valueOf(this.aTP));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.asj().endTransaction();
        }
    }
}
