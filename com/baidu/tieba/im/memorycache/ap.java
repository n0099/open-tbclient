package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao dhM;
    private final /* synthetic */ ImMessageCenterPojo dhN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dhM = aoVar;
        this.dhN = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.aso().c(this.dhN);
        return null;
    }
}
