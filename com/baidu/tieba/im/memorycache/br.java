package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class br implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bq a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, String str) {
        this.a = bqVar;
        this.b = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.a().d(this.b);
        }
        return null;
    }
}
