package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b cSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.cSe = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid("-1000");
        imMessageCenterPojo.setCustomGroupType(-8);
        imMessageCenterPojo.setIs_hidden(1);
        com.baidu.tieba.im.db.i.amO().c(imMessageCenterPojo);
        return null;
    }
}
