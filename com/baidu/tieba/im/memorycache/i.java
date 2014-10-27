package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ c bcU;
    private final /* synthetic */ ImMessageCenterPojo bcX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bcU = cVar;
        this.bcX = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.MF().a(this.bcX);
        return null;
    }
}
