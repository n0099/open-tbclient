package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw biZ;
    private final /* synthetic */ long bja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, long j) {
        this.biZ = awVar;
        this.bja = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.MP().MQ();
            com.baidu.tieba.im.db.k.MU().z(String.valueOf(this.bja), 2);
            com.baidu.tieba.im.db.o.Nf().gm(String.valueOf(this.bja));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.MP().endTransaction();
        }
    }
}
