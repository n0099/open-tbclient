package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo cnH;
    final /* synthetic */ ax cnX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnX = axVar;
        this.cnH = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aet().aeu();
            com.baidu.tieba.im.db.i.aex().c(this.cnH);
            if (this.cnH.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.aep().jf(this.cnH.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.aet().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.cnH);
    }
}
