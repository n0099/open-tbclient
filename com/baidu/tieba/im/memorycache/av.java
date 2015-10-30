package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class av implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ au bEM;
    private final /* synthetic */ ImMessageCenterPojo bEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEM = auVar;
        this.bEx = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.i.TK().c(this.bEx);
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
