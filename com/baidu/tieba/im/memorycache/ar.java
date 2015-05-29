package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ar implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao bmZ;
    private final /* synthetic */ ImMessageCenterPojo bnb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bmZ = aoVar;
        this.bnb = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Rq().Rr();
            com.baidu.tieba.im.db.c.Rm().gW(this.bnb.getGid());
            com.baidu.tieba.im.db.k.Rv().a(this.bnb);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.Rq().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
