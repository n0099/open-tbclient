package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bx implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bbN;
    final /* synthetic */ bw bet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, String str) {
        this.bet = bwVar;
        this.bbN = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            com.baidu.tieba.im.db.c.MA().fV(this.bbN);
        }
        return null;
    }
}
