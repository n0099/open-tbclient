package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ c bgA;
    private final /* synthetic */ ImMessageCenterPojo bgD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bgA = cVar;
        this.bgD = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.MD().a(this.bgD);
        return null;
    }
}
