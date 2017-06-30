package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aXu;
    final /* synthetic */ as dlD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.dlD = asVar;
        this.aXu = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.asd().ase();
            com.baidu.tieba.im.db.j.asi().W(String.valueOf(this.aXu), 2);
            com.baidu.tieba.im.db.m.aso().lw(String.valueOf(this.aXu));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.asd().endTransaction();
        }
    }
}
