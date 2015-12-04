package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bUk;
    private final /* synthetic */ ImMessageCenterPojo bUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bUk = anVar;
        this.bUl = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.Xl().c(this.bUl);
        return null;
    }
}
