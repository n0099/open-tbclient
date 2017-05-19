package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aYz;
    final /* synthetic */ as cYh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.cYh = asVar;
        this.aYz = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.ans().ant();
            com.baidu.tieba.im.db.j.anx().U(String.valueOf(this.aYz), 2);
            com.baidu.tieba.im.db.m.anD().ko(String.valueOf(this.aYz));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.ans().endTransaction();
        }
    }
}
