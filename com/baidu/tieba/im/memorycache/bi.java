package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, String str) {
        this.a = imMemoryCacheRegisterStatic;
        this.b = str;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof CustomMessage)) {
            try {
                com.baidu.tieba.im.db.g.a().b();
                com.baidu.tieba.im.db.k.a().a(this.b, 1);
                com.baidu.tieba.im.db.c.a().d(this.b);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.a().c();
            }
        }
        return null;
    }
}
