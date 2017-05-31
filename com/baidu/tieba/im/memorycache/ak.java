package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ak implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aj ddB;
    private final /* synthetic */ ImMessageCenterPojo dds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ddB = ajVar;
        this.dds = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.aos().aot();
                com.baidu.tieba.im.db.j.aox().c(this.dds);
                com.baidu.tieba.im.db.c.aoo().kB(this.dds.getGid());
                com.baidu.tieba.im.db.g.aos().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.aos().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.aos().endTransaction();
            throw th;
        }
    }
}
