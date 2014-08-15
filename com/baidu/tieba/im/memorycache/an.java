package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class an implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.f> {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.f> customMessage) {
        com.baidu.tieba.im.message.f data = customMessage.getData();
        com.baidu.tieba.im.db.k.a().c(data.a, data.b);
        return null;
    }
}
