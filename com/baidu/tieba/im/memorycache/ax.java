package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bTZ;
    final /* synthetic */ aw bUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bUp = awVar;
        this.bTZ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Xg().Xh();
            com.baidu.tieba.im.db.i.Xl().c(this.bTZ);
            if (this.bTZ.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.Xc().ig(this.bTZ.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Xg().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.bTZ);
    }
}
