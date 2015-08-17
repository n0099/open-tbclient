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
    private final /* synthetic */ ImMessageCenterPojo bAD;
    final /* synthetic */ aw bAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAR = awVar;
        this.bAD = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.SZ().Ta();
            com.baidu.tieba.im.db.i.Te().a(this.bAD);
            if (this.bAD.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.SV().hw(this.bAD.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.SZ().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.bAD);
    }
}
