package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw bdZ;
    private final /* synthetic */ long bea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, long j) {
        this.bdZ = awVar;
        this.bea = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.MA().MB();
            com.baidu.tieba.im.db.k.MF().x(String.valueOf(this.bea), 2);
            com.baidu.tieba.im.db.o.MQ().fV(String.valueOf(this.bea));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.MA().endTransaction();
        }
    }
}
