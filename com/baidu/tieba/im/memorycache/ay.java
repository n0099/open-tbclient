package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bmQ;
    final /* synthetic */ ax bne;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bne = axVar;
        this.bmQ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Rq().Rr();
            com.baidu.tieba.im.db.k.Rv().a(this.bmQ);
            if (this.bmQ.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.Rm().gW(this.bmQ.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Rq().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.bmQ);
    }
}
