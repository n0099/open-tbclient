package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bu implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bnh;
    final /* synthetic */ bt bnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar, String str) {
        this.bnj = btVar;
        this.bnh = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.Rm().gX(this.bnh);
        }
        return null;
    }
}
