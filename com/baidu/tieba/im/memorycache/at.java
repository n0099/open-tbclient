package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aGB;
    final /* synthetic */ ar bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, long j) {
        this.bEL = arVar;
        this.aGB = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.TJ().TK();
            com.baidu.tieba.im.db.i.TO().E(String.valueOf(this.aGB), 2);
            com.baidu.tieba.im.db.l.TU().hG(String.valueOf(this.aGB));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.TJ().endTransaction();
        }
    }
}
