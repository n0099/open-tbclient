package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aWb;
    final /* synthetic */ as ddH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.ddH = asVar;
        this.aWb = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aos().aot();
            com.baidu.tieba.im.db.j.aox().U(String.valueOf(this.aWb), 2);
            com.baidu.tieba.im.db.m.aoD().ky(String.valueOf(this.aWb));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.aos().endTransaction();
        }
    }
}
