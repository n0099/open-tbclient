package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aNT;
    final /* synthetic */ as cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.cmY = asVar;
        this.aNT = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aet().aeu();
            com.baidu.tieba.im.db.i.aey().R(String.valueOf(this.aNT), 2);
            com.baidu.tieba.im.db.l.aeE().ja(String.valueOf(this.aNT));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.aet().endTransaction();
        }
    }
}
