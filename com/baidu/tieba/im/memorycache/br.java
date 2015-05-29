package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class br implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bmQ;
    final /* synthetic */ bq bni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bni = bqVar;
        this.bmQ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.Rm().gW(this.bmQ.getGid());
        }
        return null;
    }
}
