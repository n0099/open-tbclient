package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bs implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bkC;
    final /* synthetic */ br bkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, String str) {
        this.bkE = brVar;
        this.bkC = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.PX().gs(this.bkC);
        }
        return null;
    }
}
