package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aw implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo ccf;
    final /* synthetic */ av ccu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ccu = avVar;
        this.ccf = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.i.abc().c(this.ccf);
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
