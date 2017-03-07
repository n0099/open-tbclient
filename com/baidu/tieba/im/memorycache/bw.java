package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bw implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String ddA;
    final /* synthetic */ bv ddC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, String str) {
        this.ddC = bvVar;
        this.ddA = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.apB().kd(this.ddA);
        }
        return null;
    }
}
