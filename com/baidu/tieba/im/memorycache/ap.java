package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao bhB;
    private final /* synthetic */ ImMessageCenterPojo bhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhB = aoVar;
        this.bhq = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            try {
                com.baidu.tieba.im.db.g.My().Mz();
                com.baidu.tieba.im.db.k.MD().a(this.bhq);
                com.baidu.tieba.im.db.c.Mu().gm(this.bhq.getGid());
                com.baidu.tieba.im.db.g.My().endTransaction();
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                com.baidu.tieba.im.db.g.My().endTransaction();
                return null;
            }
        } catch (Throwable th) {
            com.baidu.tieba.im.db.g.My().endTransaction();
            throw th;
        }
    }
}
