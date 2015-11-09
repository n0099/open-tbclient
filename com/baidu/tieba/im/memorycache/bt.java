package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bt implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bFl;
    final /* synthetic */ bs bFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, String str) {
        this.bFn = bsVar;
        this.bFl = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.TW().hI(this.bFl);
        }
        return null;
    }
}
