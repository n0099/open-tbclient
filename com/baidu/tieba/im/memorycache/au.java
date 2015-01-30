package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class au implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar biX;
    private final /* synthetic */ ImMessageCenterPojo biZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.biX = arVar;
        this.biZ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.MU().MV();
            com.baidu.tieba.im.db.c.MQ().gr(this.biZ.getGid());
            com.baidu.tieba.im.db.k.MZ().a(this.biZ);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.MU().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
