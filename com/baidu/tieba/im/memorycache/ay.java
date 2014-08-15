package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class ay implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ aw a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, long j) {
        this.a = awVar;
        this.b = j;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.a().b();
            com.baidu.tieba.im.db.k.a().a(String.valueOf(this.b), 2);
            com.baidu.tieba.im.db.o.c().d(String.valueOf(this.b));
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        } finally {
            com.baidu.tieba.im.db.g.a().c();
        }
    }
}
