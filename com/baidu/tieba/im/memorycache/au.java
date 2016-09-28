package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aUz;
    final /* synthetic */ as djm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.djm = asVar;
        this.aUz = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.asI().asJ();
            com.baidu.tieba.im.db.i.asN().ac(String.valueOf(this.aUz), 2);
            com.baidu.tieba.im.db.l.asT().ly(String.valueOf(this.aUz));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.asI().endTransaction();
        }
    }
}
