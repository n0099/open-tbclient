package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aIu;
    final /* synthetic */ ar bUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, long j) {
        this.bUn = arVar;
        this.aIu = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Xg().Xh();
            com.baidu.tieba.im.db.i.Xl().J(String.valueOf(this.aIu), 2);
            com.baidu.tieba.im.db.l.Xr().ic(String.valueOf(this.aIu));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Xg().endTransaction();
        }
    }
}
