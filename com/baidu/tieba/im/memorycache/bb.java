package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bb implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bDA;
    final /* synthetic */ ba bEE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEE = baVar;
        this.bDA = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.TO().a(this.bDA, 1);
        return null;
    }
}
