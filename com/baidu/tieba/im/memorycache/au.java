package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar bhC;
    private final /* synthetic */ ImMessageCenterPojo bhE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhC = arVar;
        this.bhE = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.My().Mz();
            com.baidu.tieba.im.db.c.Mu().gm(this.bhE.getGid());
            com.baidu.tieba.im.db.k.MD().a(this.bhE);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.My().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
