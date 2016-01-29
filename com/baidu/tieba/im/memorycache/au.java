package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aKX;
    final /* synthetic */ as cct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.cct = asVar;
        this.aKX = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aaX().aaY();
            com.baidu.tieba.im.db.i.abc().K(String.valueOf(this.aKX), 2);
            com.baidu.tieba.im.db.l.abi().ir(String.valueOf(this.aKX));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.aaX().endTransaction();
        }
    }
}
