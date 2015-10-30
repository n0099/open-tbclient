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
    final /* synthetic */ aw bEN;
    private final /* synthetic */ ImMessageCenterPojo bEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEN = awVar;
        this.bEx = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.TF().TG();
            com.baidu.tieba.im.db.i.TK().c(this.bEx);
            if (this.bEx.getCustomGroupType() == 1) {
                com.baidu.tieba.im.db.c.TB().hJ(this.bEx.getGid());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.TF().endTransaction();
        }
        return new ResponseMemoryNotifyUpdataGroupMessage(this.bEx);
    }
}
