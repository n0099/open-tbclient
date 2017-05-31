package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
/* loaded from: classes.dex */
class ai implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
    final /* synthetic */ ah ddA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.ddA = ahVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
        MemoryClearUnreadCountMessage.a data = customMessage.getData();
        com.baidu.tieba.im.db.j.aox().W(data.id, data.customGroupType);
        return null;
    }
}
