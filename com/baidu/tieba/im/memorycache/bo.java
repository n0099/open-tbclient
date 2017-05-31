package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ String ddO;
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ImMemoryCacheRegister imMemoryCacheRegister, String str) {
        this.this$0 = imMemoryCacheRegister;
        this.ddO = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            try {
                com.baidu.tieba.im.db.g.aos().aot();
                com.baidu.tieba.im.db.j.aox().U(this.ddO, 1);
                com.baidu.tieba.im.db.c.aoo().ky(this.ddO);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aos().endTransaction();
            }
        }
        return null;
    }
}
