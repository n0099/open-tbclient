package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ long aOv;
    final /* synthetic */ as cWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, long j) {
        this.cWf = asVar;
        this.aOv = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.anu().anv();
            com.baidu.tieba.im.db.i.anz().ac(String.valueOf(this.aOv), 2);
            com.baidu.tieba.im.db.l.anF().kC(String.valueOf(this.aOv));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.anu().endTransaction();
        }
    }
}
