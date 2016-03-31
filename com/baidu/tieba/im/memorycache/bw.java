package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bw implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String cnf;
    final /* synthetic */ bv cnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, String str) {
        this.cnh = bvVar;
        this.cnf = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.aep().ja(this.cnf);
        }
        return null;
    }
}
