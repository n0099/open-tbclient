package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw bhF;
    private final /* synthetic */ long bhG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, long j) {
        this.bhF = awVar;
        this.bhG = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.My().Mz();
            com.baidu.tieba.im.db.k.MD().z(String.valueOf(this.bhG), 2);
            com.baidu.tieba.im.db.o.MO().gk(String.valueOf(this.bhG));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.My().endTransaction();
        }
    }
}
