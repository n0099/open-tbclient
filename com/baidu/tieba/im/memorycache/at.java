package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aFv;
    final /* synthetic */ ar bFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, long j) {
        this.bFg = arVar;
        this.aFv = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Ua().Ub();
            com.baidu.tieba.im.db.i.Uf().E(String.valueOf(this.aFv), 2);
            com.baidu.tieba.im.db.l.Ul().hI(String.valueOf(this.aFv));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Ua().endTransaction();
        }
    }
}
