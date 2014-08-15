package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class n implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int a = com.baidu.adp.lib.e.b.a(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.n.c().e(String.valueOf(a))) {
            return null;
        }
        return new CustomResponsedMessage<>(2001155, String.valueOf(a));
    }
}
