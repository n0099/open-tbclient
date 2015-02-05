package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar biW;
    private final /* synthetic */ ImMessageCenterPojo biY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.biW = arVar;
        this.biY = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.MP().MQ();
            com.baidu.tieba.im.db.c.ML().go(this.biY.getGid());
            com.baidu.tieba.im.db.k.MU().a(this.biY);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.MP().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
