package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class be implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bd cTp;
    private final /* synthetic */ List cTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.cTp = bdVar;
        this.cTq = list;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        for (ImMessageCenterPojo imMessageCenterPojo : this.cTq) {
            com.baidu.tieba.im.db.i.amO().c(imMessageCenterPojo);
        }
        return null;
    }
}
