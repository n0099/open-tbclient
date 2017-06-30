package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bt implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bs dlL;
    private final /* synthetic */ ImMessageCenterPojo dlp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dlL = bsVar;
        this.dlp = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.arZ().lz(this.dlp.getGid());
        }
        return null;
    }
}
