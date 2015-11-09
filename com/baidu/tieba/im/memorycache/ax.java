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
    private final /* synthetic */ ImMessageCenterPojo bES;
    final /* synthetic */ aw bFi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFi = awVar;
        this.bES = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Ua().Ub();
            com.baidu.tieba.im.db.i.Uf().c(this.bES);
            if (this.bES.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.TW().hL(this.bES.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Ua().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.bES);
    }
}
