package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class az implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ay bED;
    private final /* synthetic */ ImMessageCenterPojo bEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bED = ayVar;
        this.bEm = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.i.TO().a(this.bEm, 2);
        }
        return null;
    }
}
