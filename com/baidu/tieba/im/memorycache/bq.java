package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bp bEG;
    private final /* synthetic */ ImMessageCenterPojo bEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEG = bpVar;
        this.bEm = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.TF().hJ(this.bEm.getGid());
        }
        return null;
    }
}
