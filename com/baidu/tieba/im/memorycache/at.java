package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aHx;
    final /* synthetic */ ar bBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, long j) {
        this.bBw = arVar;
        this.aHx = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Tb().Tc();
            com.baidu.tieba.im.db.i.Tg().C(String.valueOf(this.aHx), 2);
            com.baidu.tieba.im.db.l.Tm().hC(String.valueOf(this.aHx));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.Tb().endTransaction();
        }
    }
}
