package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar bek;
    private final /* synthetic */ ImMessageCenterPojo bem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bek = arVar;
        this.bem = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.ME().MF();
            com.baidu.tieba.im.db.c.MA().fX(this.bem.getGid());
            com.baidu.tieba.im.db.k.MJ().a(this.bem);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.ME().endTransaction();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
