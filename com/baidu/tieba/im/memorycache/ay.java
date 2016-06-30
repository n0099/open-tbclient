package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo cSW;
    final /* synthetic */ ax cTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cTm = axVar;
        this.cSW = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.amK().amL();
            com.baidu.tieba.im.db.i.amO().c(this.cSW);
            if (this.cSW.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.amG().ky(this.cSW.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.amK().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.cSW);
    }
}
