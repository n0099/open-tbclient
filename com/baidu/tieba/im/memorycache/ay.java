package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw ben;
    private final /* synthetic */ long beo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, long j) {
        this.ben = awVar;
        this.beo = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.ME().MF();
            com.baidu.tieba.im.db.k.MJ().x(String.valueOf(this.beo), 2);
            com.baidu.tieba.im.db.o.MU().fV(String.valueOf(this.beo));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.ME().endTransaction();
        }
    }
}
