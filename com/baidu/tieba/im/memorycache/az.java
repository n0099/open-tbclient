package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class az implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bES;
    final /* synthetic */ ay bFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFj = ayVar;
        this.bES = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.i.Uf().a(this.bES, 2);
        }
        return null;
    }
}
