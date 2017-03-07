package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class be implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bd ddy;
    private final /* synthetic */ List ddz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.ddy = bdVar;
        this.ddz = list;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        for (ImMessageCenterPojo imMessageCenterPojo : this.ddz) {
            com.baidu.tieba.im.db.i.apK().c(imMessageCenterPojo);
        }
        return null;
    }
}
