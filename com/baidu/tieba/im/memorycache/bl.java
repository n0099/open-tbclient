package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bEQ;
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, String str) {
        this.this$0 = imMemoryCacheRegisterStatic;
        this.bEQ = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            try {
                com.baidu.tieba.im.db.g.TJ().TK();
                com.baidu.tieba.im.db.i.TO().E(this.bEQ, 1);
                com.baidu.tieba.im.db.c.TF().hG(this.bEQ);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.TJ().endTransaction();
            }
        }
        return null;
    }
}
