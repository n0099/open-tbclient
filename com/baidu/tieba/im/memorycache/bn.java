package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bn implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bm a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.a = bmVar;
        this.b = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.a().e(this.b);
        }
        return null;
    }
}
