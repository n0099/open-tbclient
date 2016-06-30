package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao cTh;
    private final /* synthetic */ ImMessageCenterPojo cTi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cTh = aoVar;
        this.cTi = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.amO().c(this.cTi);
        return null;
    }
}
