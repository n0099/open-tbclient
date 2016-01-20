package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aJS;
    final /* synthetic */ as bXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.bXZ = asVar;
        this.aJS = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Ym().Yn();
            com.baidu.tieba.im.db.i.Yr().J(String.valueOf(this.aJS), 2);
            com.baidu.tieba.im.db.l.Yx().iq(String.valueOf(this.aJS));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Ym().endTransaction();
        }
    }
}
