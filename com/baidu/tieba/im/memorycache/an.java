package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class an implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.live.message.a> {
    final /* synthetic */ am bhA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bhA = amVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.live.message.a> customMessage) {
        com.baidu.tbadk.live.message.a data = customMessage.getData();
        com.baidu.tieba.im.db.k.MD().B(data.id, data.customGroupType);
        return null;
    }
}
