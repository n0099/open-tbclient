package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ar a;
    private final /* synthetic */ ImMessageCenterPojo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.a = arVar;
        this.b = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.a().b();
            com.baidu.tieba.im.db.c.a().e(this.b.getGid());
            com.baidu.tieba.im.db.k.a().a(this.b);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.a().c();
        }
        return new CustomResponsedMessage<>(2001220);
    }
}
