package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
/* loaded from: classes.dex */
class ah implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
    final /* synthetic */ ag bEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bEt = agVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
        MemoryClearUnreadCountMessage.a data = customMessage.getData();
        com.baidu.tieba.im.db.i.TO().G(data.id, data.customGroupType);
        return null;
    }
}
