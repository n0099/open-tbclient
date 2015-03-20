package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ c bjh;
    private final /* synthetic */ ImMessageCenterPojo bjk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjh = cVar;
        this.bjk = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.PT().a(this.bjk);
        return null;
    }
}
