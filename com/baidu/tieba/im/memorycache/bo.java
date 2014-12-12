package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String bhK;
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, String str) {
        this.this$0 = imMemoryCacheRegisterStatic;
        this.bhK = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            try {
                com.baidu.tieba.im.db.g.My().Mz();
                com.baidu.tieba.im.db.k.MD().z(this.bhK, 1);
                com.baidu.tieba.im.db.c.Mu().gk(this.bhK);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.My().endTransaction();
            }
        }
        return null;
    }
}
