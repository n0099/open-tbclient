package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b cbn;
    private final /* synthetic */ ImMessageCenterPojo cbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cbn = bVar;
        this.cbq = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.abc().c(this.cbq);
        return null;
    }
}
