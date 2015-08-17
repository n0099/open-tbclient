package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aHk;
    final /* synthetic */ ar bAP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, long j) {
        this.bAP = arVar;
        this.aHk = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.SZ().Ta();
            com.baidu.tieba.im.db.i.Te().B(String.valueOf(this.aHk), 2);
            com.baidu.tieba.im.db.l.Tk().ht(String.valueOf(this.aHk));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.SZ().endTransaction();
        }
    }
}
