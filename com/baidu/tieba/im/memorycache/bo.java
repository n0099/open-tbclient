package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String cTr;
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, String str) {
        this.this$0 = imMemoryCacheRegisterStatic;
        this.cTr = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            try {
                com.baidu.tieba.im.db.g.amK().amL();
                com.baidu.tieba.im.db.i.amO().ac(this.cTr, 1);
                com.baidu.tieba.im.db.c.amG().kv(this.cTr);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.amK().endTransaction();
            }
        }
        return null;
    }
}
