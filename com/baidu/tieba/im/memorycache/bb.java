package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bb implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ba bAT;
    private final /* synthetic */ ImMessageCenterPojo bzR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAT = baVar;
        this.bzR = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Te().a(this.bzR, 1);
        return null;
    }
}
