package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao cnS;
    private final /* synthetic */ ImMessageCenterPojo cnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnS = aoVar;
        this.cnT = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.aex().c(this.cnT);
        return null;
    }
}
