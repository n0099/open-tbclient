package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar bhC;
    private final /* synthetic */ ImMessageCenterPojo bhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhC = arVar;
        this.bhD = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.MD().a(this.bhD);
        return null;
    }
}
