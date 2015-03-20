package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ar implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao bkf;
    private final /* synthetic */ ImMessageCenterPojo bkh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkf = aoVar;
        this.bkh = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.PO().PP();
            com.baidu.tieba.im.db.c.PK().gr(this.bkh.getGid());
            com.baidu.tieba.im.db.k.PT().a(this.bkh);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.PO().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
