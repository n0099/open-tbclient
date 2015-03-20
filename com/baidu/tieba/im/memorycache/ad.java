package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bjk;
    final /* synthetic */ ac bka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bka = acVar;
        this.bjk = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.PT().a(this.bjk, 2);
        return null;
    }
}
