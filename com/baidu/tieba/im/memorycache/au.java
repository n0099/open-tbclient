package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aYd;
    final /* synthetic */ as deh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.deh = asVar;
        this.aYd = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aqz().aqA();
            com.baidu.tieba.im.db.j.aqE().T(String.valueOf(this.aYd), 2);
            com.baidu.tieba.im.db.m.aqK().kk(String.valueOf(this.aYd));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.aqz().endTransaction();
        }
    }
}
