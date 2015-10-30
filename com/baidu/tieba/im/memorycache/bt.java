package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bt implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bEQ;
    final /* synthetic */ bs bES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, String str) {
        this.bES = bsVar;
        this.bEQ = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.TB().hG(this.bEQ);
        }
        return null;
    }
}
