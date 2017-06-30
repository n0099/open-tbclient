package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ba implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ az dlG;
    private final /* synthetic */ ImMessageCenterPojo dlp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dlG = azVar;
        this.dlp = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.j.asi().a(this.dlp, 2);
        }
        return null;
    }
}
