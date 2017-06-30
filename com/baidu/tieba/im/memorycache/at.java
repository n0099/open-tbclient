package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ as dlD;
    private final /* synthetic */ ImMessageCenterPojo dlp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dlD = asVar;
        this.dlp = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.j.asi().c(this.dlp);
        return null;
    }
}
