package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ c bhS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.bhS = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid("-1000");
        imMessageCenterPojo.setCustomGroupType(-8);
        imMessageCenterPojo.setIs_hidden(1);
        com.baidu.tieba.im.db.k.MZ().a(imMessageCenterPojo);
        return null;
    }
}
