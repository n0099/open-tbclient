package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ba implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo ccf;
    final /* synthetic */ az ccw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ccw = azVar;
        this.ccf = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.i.abc().a(this.ccf, 2);
        }
        return null;
    }
}
