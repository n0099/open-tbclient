package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aYa;
    final /* synthetic */ as dbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.dbO = asVar;
        this.aYa = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.apy().apz();
            com.baidu.tieba.im.db.j.apD().T(String.valueOf(this.aYa), 2);
            com.baidu.tieba.im.db.m.apJ().kj(String.valueOf(this.aYa));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.apy().endTransaction();
        }
    }
}
