package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar bdW;
    private final /* synthetic */ ImMessageCenterPojo bdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bdW = arVar;
        this.bdX = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.MF().a(this.bdX);
        return null;
    }
}
